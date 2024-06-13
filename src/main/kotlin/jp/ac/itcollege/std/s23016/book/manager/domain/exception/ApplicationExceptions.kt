package jp.ac.itcollege.std.s23016.book.manager.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookNotFoundException(override val message: String) : Exception()

@ResponseStatus(HttpStatus.CONFLICT)
class BookIdAlreadyUseException(override val message: String) : Exception(message)

@ResponseStatus(HttpStatus.BAD_REQUEST)
class RentalStateException(override val message: String) : Exception()

@ResponseStatus(HttpStatus.CONFLICT)
class BookNotAvailableException(override val message: String) : Exception()