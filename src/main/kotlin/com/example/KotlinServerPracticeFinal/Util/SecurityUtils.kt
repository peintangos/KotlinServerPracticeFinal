package com.example.KotlinServerPracticeFinal.Util

import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

private final class SecurityUtils {
    private constructor()
    companion object{
        fun getAuthentication():UsernamePasswordAuthenticationToken{
            val authentication = SecurityContextHolder.getContext().authentication
            if(authentication !is UsernamePasswordAuthenticationToken){
                throw AuthenticationServiceException("トークンの種類が誤っています。")
            }
            return authentication as UsernamePasswordAuthenticationToken
        }
    }
}