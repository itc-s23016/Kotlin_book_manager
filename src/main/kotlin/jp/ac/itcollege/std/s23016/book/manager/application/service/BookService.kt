package jp.ac.itcollege.std.s23016.book.manager.application.service

import jp.ac.itcollege.std.s23016.book.manager.domain.model.BookWithRental
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.BookRepository
import jp.ac.itcollege.std.s23016.book.manager.domain.exception.BookNotFoundException
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental()
    }

    fun getDetail(bookid: Long): BookWithRental {
        return bookRepository.findWithRental(bookid)
            ?: throw BookNotFoundException("存在しない書籍ID: $bookid")
    }
}