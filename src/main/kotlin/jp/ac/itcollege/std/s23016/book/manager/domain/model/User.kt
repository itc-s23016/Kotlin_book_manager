package jp.ac.itcollege.std.s23016.book.manager.domain.model

import jp.ac.itcollege.std.s23016.book.manager.domain.types.RoleType

data class User(
    val id: Long,
    val email: String,
    val password: String,
    val name: String,
    val roleType: RoleType
)
