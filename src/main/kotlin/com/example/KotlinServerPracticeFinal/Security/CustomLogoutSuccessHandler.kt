package com.example.KotlinServerPracticeFinal.Security

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomLogoutSuccessHandler:LogoutSuccessHandler {
    override fun onLogoutSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
        response?.writer?.write("{}")
        response?.writer?.flush()
    }
}