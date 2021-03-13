package com.example.KotlinServerPracticeFinal.Security

import com.example.KotlinServerPracticeFinal.Dto.LoginMessage
import com.example.KotlinServerPracticeFinal.Util.JacksoHelper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAuthenticationFilter: UsernamePasswordAuthenticationFilter() {
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        if (!request!!.method.equals("POST")){
            throw AuthenticationServiceException("ポストメソッドではありません")
        }
//        TODO nullチェックいるかも。(空文字はあくまで文字なので、検索結果がないと出るだけ。）
        val loginMessage = jacksonObjectMapper().readValue<LoginMessage>(request!!.reader,LoginMessage::class.java)
        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(loginMessage,null)
        setDetails(request,usernamePasswordAuthenticationToken)
        return this.authenticationManager.authenticate(usernamePasswordAuthenticationToken)
    }

}