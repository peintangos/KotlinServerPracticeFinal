package com.example.KotlinServerPracticeFinal.Dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Value
import org.springframework.http.HttpStatus

@Value
data class ErrorRespMsg(val error:String,val status:HttpStatus,val message:String){
}