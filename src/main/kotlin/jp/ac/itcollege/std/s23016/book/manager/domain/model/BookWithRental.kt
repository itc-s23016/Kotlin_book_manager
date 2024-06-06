package jp.ac.itcollege.std.s23016.book.manager.domain.model

data class BookWithRental(
    val book: Book,
    val rental: Rental?
) {
    val isRental: Boolean
        get() = rental != null
}
