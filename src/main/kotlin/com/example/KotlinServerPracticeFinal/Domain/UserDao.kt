package com.example.KotlinServerPracticeFinal.Domain

import com.example.KotlinServerPracticeFinal.Dto.LoginMessage
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.log

@Table("User")
data class UserDao(@Id val id:Int? = null, var name:String, var pass:String, var isDeleted:Boolean = false, val createdTime:LocalDate = LocalDate.now()) {
    companion object{
//        idには、nullを入れてあげること。@Idを付与してあげることで自動裁判する。
        fun ofUserDao(loginMessage: LoginMessage):UserDao{
            return UserDao(null,loginMessage.name, BCryptPasswordEncoder().encode(loginMessage.password),false,LocalDate.now())
        }
    }
}