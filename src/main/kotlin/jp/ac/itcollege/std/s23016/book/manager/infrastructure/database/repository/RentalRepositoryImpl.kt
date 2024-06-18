package jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.repository

import jp.ac.itcollege.std.s23016.book.manager.domain.model.Rental
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.RentalRepository
import jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao.BookEntity
import jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao.RentalEntity
import jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao.RentalTable
import jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao.UserEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class RentalRepositoryImpl : RentalRepository {
    override fun startRental(rental: Rental) {
        transaction {
            val bookEntity = BookEntity.findById(rental.bookId)
                ?: throw IllegalStateException("書籍ID ${rental.bookId} が見つかりません")
            val userEntity = UserEntity.findById(rental.userId)
                ?: throw IllegalStateException("ユーザーID ${rental.userId} が見つかりません")

            RentalEntity.new {
                book = bookEntity
                user = userEntity
                rentalDateTime = rental.rentalDateTime
                returnDeadline = rental.returnDeadline
            }
        }
    }

    override fun endRental(bookId: Long) {
        transaction {
            RentalEntity.find {
                RentalTable.book eq bookId
            }.singleOrNull()?.delete()
        }
    }
}