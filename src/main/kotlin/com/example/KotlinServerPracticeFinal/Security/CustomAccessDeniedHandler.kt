package com.example.KotlinServerPracticeFinal.Security

import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAccessDeniedHandler: AccessDeniedHandler {
    override fun handle(request: HttpServletRequest?, response: HttpServletResponse?, accessDeniedException: AccessDeniedException?) {
        response?.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response?.setContentType("application/json");
        response?.setCharacterEncoding("utf-8");
    }
}