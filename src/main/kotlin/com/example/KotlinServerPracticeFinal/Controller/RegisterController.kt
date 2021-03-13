package com.example.KotlinServerPracticeFinal.Controller

import com.example.KotlinServerPracticeFinal.Dto.LoginMessage
import com.example.KotlinServerPracticeFinal.Dto.SucessRespMsg
import com.example.KotlinServerPracticeFinal.Service.UserAppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class RegisterController {
    @Autowired
    private lateinit var userAppService: UserAppService
    @PostMapping("/register")
    fun register(@RequestBody loginMessage:LoginMessage):SucessRespMsg{
        userAppService.register(loginMessage)
        return SucessRespMsg("OK",HttpStatus.OK,"登録しました。")
    }
}