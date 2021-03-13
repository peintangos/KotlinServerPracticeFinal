package com.example.KotlinServerPracticeFinal.Security

import com.example.KotlinServerPracticeFinal.Dto.ErrorRespMsg
import com.example.KotlinServerPracticeFinal.Util.JacksoHelper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthenticationFailureHandler:SimpleUrlAuthenticationFailureHandler() {

    override fun onAuthenticationFailure(request: HttpServletRequest?, response: HttpServletResponse?, exception: AuthenticationException?) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR
        if (exception is BadCredentialsException){
            status = HttpStatus.UNAUTHORIZED
        }
        response?.status = status.value()
        response?.contentType = MediaType.APPLICATION_JSON.toString()
        response?.characterEncoding = StandardCharsets.UTF_8.toString()
        val writer = response?.writer
        jacksonObjectMapper().writeValue(writer, ErrorRespMsg("エラー",HttpStatus.UNAUTHORIZED,"ユーザー名またはパスワードが間違っています"))
        writer?.flush()
    }
}