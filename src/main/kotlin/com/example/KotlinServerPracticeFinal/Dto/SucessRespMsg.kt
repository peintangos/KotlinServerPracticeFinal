package com.example.KotlinServerPracticeFinal.Dto

import org.springframework.http.HttpStatus

class SucessRespMsg(val title:String, val status: HttpStatus, val message:String) {
}