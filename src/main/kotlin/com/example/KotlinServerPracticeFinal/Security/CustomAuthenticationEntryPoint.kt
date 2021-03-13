package com.example.KotlinServerPracticeFinal.Security

import com.example.KotlinServerPracticeFinal.Dto.ErrorRespMsg
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthenticationEntryPoint:AuthenticationEntryPoint {
    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        response?.status = HttpStatus.BAD_GATEWAY.value()
        response?.contentType = "application/json"
        response?.characterEncoding = "utf-8"
        jacksonObjectMapper().writeValue(response?.writer, ErrorRespMsg("エラー",HttpStatus.BAD_REQUEST,"パスが間違っています。"))
        response?.writer?.flush()
    }
}