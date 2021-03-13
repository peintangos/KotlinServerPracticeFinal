package com.example.KotlinServerPracticeFinal.Domain

import org.springframework.data.relational.core.mapping.Table

@Table("User")
data class UserDao(val id:String,val name:String,val pass:String) {
}