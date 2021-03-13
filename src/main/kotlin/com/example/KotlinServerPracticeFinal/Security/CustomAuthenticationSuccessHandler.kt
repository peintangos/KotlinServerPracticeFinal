package com.example.KotlinServerPracticeFinal.Security

import com.example.KotlinServerPracticeFinal.Dto.ErrorRespMsg
import com.example.KotlinServerPracticeFinal.Dto.SucessRespMsg
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.codec.Utf8
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.SuccessCallback
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthenticationSuccessHandler:AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
        val userDao = authentication?.principal
        response?.characterEncoding = "UTF-8"
        val writer = response?.writer
        jacksonObjectMapper().writeValue(writer, SucessRespMsg("OK",HttpStatus.OK,"s"))
        writer?.flush()
    }
}