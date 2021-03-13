package com.example.KotlinServerPracticeFinal.Service

import com.example.KotlinServerPracticeFinal.Domain.UserDao
import com.example.KotlinServerPracticeFinal.Dto.LoginMessage
import com.example.KotlinServerPracticeFinal.Exception.NoSameUsernameException
import com.example.KotlinServerPracticeFinal.Repository.UserRepository
import com.example.KotlinServerPracticeFinal.Util.SystemAuthority
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserAppService {
    @Autowired
    private final lateinit var userRepository:UserRepository
    fun login(loginMessage: LoginMessage):UsernamePasswordAuthenticationToken{
        val user = userRepository.findByName(loginMessage.name)
        if (user == null){
            print("ユーザー名誤り")
            throw BadCredentialsException("ユーザーが見つかりません。")
        }

        val encoder = BCryptPasswordEncoder()
        if(!encoder.matches(loginMessage.password,user.pass)){
            print("パスワード間違い")
            throw BadCredentialsException("ユーザーが見つかりません。")
        }
        val authority = mutableListOf(SystemAuthority.ROLE_USER)
        return UsernamePasswordAuthenticationToken(user.name,user.pass)
    }
    fun register(loginMessage: LoginMessage){
        if (userRepository.findByName(loginMessage.name) != null){
            throw NoSameUsernameException("既に同じユーザーネームがあります。")
        }
        userRepository.save(UserDao.ofUserDao(loginMessage))
    }
}