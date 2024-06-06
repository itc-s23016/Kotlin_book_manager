package jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class VBookWithRentalEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<VBookWithRentalEntity>(VBookWithRentalView)

    var title by VBookWithRentalView.title
    var author by VBookWithRentalView.author
    var releaseDate by VBookWithRentalView.releaseDate
    var userId by VBookWithRentalView.userId
    var rentalDateTime by VBookWithRentalView.rentalDateTime
    var returnDeadline by VBookWithRentalView.returnDeadline
}