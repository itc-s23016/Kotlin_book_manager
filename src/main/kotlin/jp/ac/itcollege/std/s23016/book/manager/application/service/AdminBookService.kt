package jp.ac.itcollege.std.s23016.book.manager.application.service

import jp.ac.itcollege.std.s23016.book.manager.domain.model.Book
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.BookRepository
import jp.ac.itcollege.std.s23016.book.manager.domain.exception.BookIdAlreadyUseException
import jp.ac.itcollege.std.s23016.book.manager.domain.exception.BookNotFoundException
import kotlinx.datetime.LocalDate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminBookService (
    private val bookRepository: BookRepository
) {
    @Transactional
    fun register(book: Book) {
        bookRepository.findWithRental(book.id)?.let {
            throw BookIdAlreadyUseException("既に存在する書籍ID: ${book.id}")
        }
        bookRepository.register(book)
    }

    @Transactional
    fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
        bookRepository.findWithRental(id) ?: throw BookNotFoundException("存在しない書籍ID: $id")

        bookRepository.update(id, title, author, releaseDate)
    }

    @Transactional
    fun delete(id: Long) {
        bookRepository.findWithRental(id) ?: BookNotFoundException("存在しない書籍ID: $id")

        bookRepository.delete(id)
    }
}