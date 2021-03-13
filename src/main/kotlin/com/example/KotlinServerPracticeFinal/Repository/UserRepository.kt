package com.example.KotlinServerPracticeFinal.Repository

import com.example.KotlinServerPracticeFinal.Domain.UserDao
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:CrudRepository<UserDao,Int> {
    fun findByName(name:String?): UserDao?
    fun existsByName(name:String?):Boolean
}