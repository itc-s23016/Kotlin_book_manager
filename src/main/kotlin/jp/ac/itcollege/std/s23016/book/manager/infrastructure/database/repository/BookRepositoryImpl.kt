package jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.repository

import jp.ac.itcollege.std.s23016.book.manager.domain.model.Book
import jp.ac.itcollege.std.s23016.book.manager.domain.model.BookWithRental
import jp.ac.itcollege.std.s23016.book.manager.domain.model.Rental
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.BookRepository
import jp.ac.itcollege.std.s23016.book.manager.infrastructure.database.dao.VBookWithRentalEntity
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl : BookRepository {
    override fun findAllWithRental(): List<BookWithRental> {
        return transaction {
            VBookWithRentalEntity.all().map(::toModel)
        }
    }

    override fun findWithRental(id: Long): BookWithRental? {
        return transaction {
            VBookWithRentalEntity.findById(id)?.let(::toModel)
        }
    }


    private fun toModel(entity: VBookWithRentalEntity): BookWithRental {
        val book = Book(
            entity.id.value,
            entity.title,
            entity.author,
            entity.releaseDate
        )
        val rental = entity.userId?.let { userId ->
            Rental(
                entity.id.value,
                userId,
                entity.rentalDateTime
                    ?: throw IllegalStateException("userId is not null, but for some reason releaseDate is null."),
                entity.returnDeadline
                    ?: throw IllegalStateException("userId is not null, but for some reason returnDeadline is null."),
            )
        }
        return BookWithRental(book, rental)
    }
}
