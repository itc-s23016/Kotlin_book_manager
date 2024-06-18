package jp.ac.itcollege.std.s23016.book.manager.presentation.controller

import jp.ac.itcollege.std.s23016.book.manager.application.service.security.BookManagerUserDetailsService
import jp.ac.itcollege.std.s23016.book.manager.application.service.security.RentalService
import jp.ac.itcollege.std.s23016.book.manager.presentation.form.RentalStartRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("rental")
@CrossOrigin
class RentalController (
    private val rentalService: RentalService
) {
    @PostMapping("/start")
    fun startRental(
        @RequestBody request: RentalStartRequest,
        @AuthenticationPrincipal user: BookManagerUserDetailsService.BookManagerUserDetails
    ) {
        rentalService.startRental(request.bookId, user.id)
    }

    @DeleteMapping("end/{book_id}")
    fun endRental(
        @PathVariable("book_id") bookId: Long,
        @AuthenticationPrincipal user: BookManagerUserDetailsService.BookManagerUserDetails
    ) {
        rentalService.endRental(bookId, user.id)
    }
}