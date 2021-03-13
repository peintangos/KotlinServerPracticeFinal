package com.example.KotlinServerPracticeFinal.Controller

import com.example.KotlinServerPracticeFinal.Dto.ErrorRespMsg
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

//アプリケーションレイヤーの例外処理を行います。
@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException::class)
    @ResponseBody
    fun badCredentialsError(badCredentialsException: BadCredentialsException):ResponseEntity<ErrorRespMsg>{
        print("こっちだよ")
        val errorRespMsg = ErrorRespMsg("BadCredentails",HttpStatus.CONFLICT,"パスワードまたはユーザーネーム間違い")
        return ResponseEntity<ErrorRespMsg>(errorRespMsg,HttpStatus.ALREADY_REPORTED)
    }
}