package com.example.KotlinServerPracticeFinal.Security

import com.example.KotlinServerPracticeFinal.Dto.LoginMessage
import com.example.KotlinServerPracticeFinal.Service.UserAppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component


@Component
class CustomAuthenticationProvider:AuthenticationProvider {
    @Autowired
    private final lateinit var userAppService: UserAppService
    override fun authenticate(authentication: Authentication?): Authentication {
        val loginMessage = authentication!!.principal as LoginMessage
        if (loginMessage == null){
            throw BadCredentialsException("LoginMessage is not found")
        }
        return userAppService.login(loginMessage)

    }

    override fun supports(authentication: Class<*>?): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}