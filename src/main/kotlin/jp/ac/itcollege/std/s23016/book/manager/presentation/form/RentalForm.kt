package jp.ac.itcollege.std.s23016.book.manager.presentation.form

import kotlinx.serialization.Serializable

@Serializable
data class RentalStartRequest(
    val bookId: Long
)