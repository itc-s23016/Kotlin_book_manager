package jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

class RentalEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<RentalEntity>(RentalTable)

    var book by BookEntity referencedOn RentalTable.book
    var user by UserEntity referencedOn RentalTable.user
    var rentalDateTime by RentalTable.rentalDatetime
    var returnDeadline by RentalTable.returnDeadline
}