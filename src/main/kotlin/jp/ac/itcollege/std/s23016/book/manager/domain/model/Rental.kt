package jp.ac.itcollege.std.s23016.book.manager.domain.model

import kotlinx.datetime.LocalDateTime

data class Rental(
    val bookId: Long,
    val userId: Long,
    val rentalDateTime: LocalDateTime,
    val returnDeadline: LocalDateTime,
)
