package jp.ac.itcollege.std.s23016.book.manager.application.service.security

import jp.ac.itcollege.std.s23016.book.manager.domain.exception.BookNotAvailableException
import jp.ac.itcollege.std.s23016.book.manager.domain.exception.RentalStateException
import jp.ac.itcollege.std.s23016.book.manager.domain.model.Rental
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.BookRepository
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.RentalRepository
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.UserRepository
import kotlinx.datetime.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private const val RENTAL_VALUE_DAYS = 14L
@Service
class RentalService (
    private val userRepository: UserRepository,
    private val bookRepository: BookRepository,
    private val rentalRepository: RentalRepository
) {
    @Transactional
    fun startRental(bookId: Long, userId: Long) {
        userRepository.find(userId)
            ?: RentalStateException("該当するユーザがいません")
        val book = bookRepository.findWithRental(bookId)
            ?: throw RentalStateException("該当する書籍がいません")
        if (book.isRental) {
            throw BookNotAvailableException("貸し出し中です")
        }

        val current = Clock.System.now()
        val rentalDatetime = current.toLocalDateTime(TimeZone.currentSystemDefault())
        val returnDeadline = current.plus(
            RENTAL_VALUE_DAYS, DateTimeUnit.DAY, TimeZone.currentSystemDefault()
        ).toLocalDateTime(TimeZone.currentSystemDefault())
        val rental = Rental(bookId, userId, rentalDatetime, returnDeadline)

        rentalRepository.startRental(rental)
    }

    @Transactional
    fun endRental(bookId: Long, userId: Long) {
        userRepository.find(userId)
            ?: throw RentalStateException("該当するユーザがいません")
        val book = bookRepository.findWithRental(bookId)
            ?: throw RentalStateException("該当する書籍がありません")
        if (!book.isRental) {
            throw RentalStateException("貸し出しされていません")
        }
        if (book.rental?.userId != userId) {
            throw RentalStateException("他のユーザが借りている書籍です")
        }
        rentalRepository.endRental(bookId)
    }
}