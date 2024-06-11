package jp.ac.itcollege.std.s23016.book.manager.presentation.controller

import jp.ac.itcollege.std.s23016.book.manager.application.service.AdminBookService
import jp.ac.itcollege.std.s23016.book.manager.domain.model.Book
import jp.ac.itcollege.std.s23016.book.manager.presentation.form.RegisterBookRequest
import jp.ac.itcollege.std.s23016.book.manager.presentation.form.UpdateBookRequest
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("admin/book")
@CrossOrigin
class AdminBookController (
    private val adminBookService: AdminBookService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterBookRequest) {
        adminBookService.register(
            request.run {
                Book(id, title, author, releaseDate)
            }
        )
    }

    @PatchMapping("/update")
    fun update(@RequestBody request: UpdateBookRequest) {
        request.run {
            adminBookService.update(id, title, author, releaseDate)
        }
    }

    @DeleteMapping("/delete/{book_id}")
    fun delete(@PathVariable("book_id") id: Long) {
        adminBookService.delete(id)
    }
}