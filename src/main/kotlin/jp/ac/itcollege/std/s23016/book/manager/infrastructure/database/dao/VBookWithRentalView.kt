package jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object VBookWithRentalView : LongIdTable("v_book_with_rental_view") {
    val title = varchar("title", 128)
    val author = varchar("author", 32)
    val releaseDate = date("release_date")
    val userId = long("user_id").nullable()
    val rentalDateTime = datetime("rental_datetime").nullable()
    val returnDeadline = datetime("return_deadline").nullable()
}