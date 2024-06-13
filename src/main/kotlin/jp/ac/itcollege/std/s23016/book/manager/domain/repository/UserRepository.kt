package jp.ac.itcollege.std.s23016.book.manager.domain.repository

import jp.ac.itcollege.std.s23016.book.manager.domain.model.User

interface UserRepository {
    fun find(email: String): User?
    fun find(id: Long): User?
}