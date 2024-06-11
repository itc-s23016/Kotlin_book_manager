package jp.ac.itcollege.std.s23016.book.manager.domain.repository

import jp.ac.itcollege.std.s23016.book.manager.domain.model.Book
import jp.ac.itcollege.std.s23016.book.manager.domain.model.BookWithRental
import kotlinx.datetime.LocalDate

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>

    fun findWithRental(id: Long): BookWithRental?

    fun register(book: Book)

    fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?)

    fun delete(id: Long)
}