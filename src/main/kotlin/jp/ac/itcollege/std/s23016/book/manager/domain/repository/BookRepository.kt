package jp.ac.itcollege.std.s23016.book.manager.domain.repository

import jp.ac.itcollege.std.s23016.book.manager.domain.model.BookWithRental

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>

    fun findWithRental(id: Long): BookWithRental?
}