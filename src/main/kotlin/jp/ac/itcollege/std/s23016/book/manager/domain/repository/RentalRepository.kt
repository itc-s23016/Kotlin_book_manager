package jp.ac.itcollege.std.s23016.book.manager.domain.repository

import jp.ac.itcollege.std.s23016.book.manager.domain.model.Rental

interface RentalRepository {
    fun startRental(rental: Rental)
}