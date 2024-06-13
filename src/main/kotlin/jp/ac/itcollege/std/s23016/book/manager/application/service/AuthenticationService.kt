package jp.ac.itcollege.std.s23016.book.manager.application.service

import jp.ac.itcollege.std.s23016.book.manager.domain.model.User
import jp.ac.itcollege.std.s23016.book.manager.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
) {
    fun findUser(email: String): User? {
        return  userRepository.find(email)
    }
}