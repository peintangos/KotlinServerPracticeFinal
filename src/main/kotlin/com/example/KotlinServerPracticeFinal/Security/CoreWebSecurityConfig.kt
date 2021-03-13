package com.example.KotlinServerPracticeFinal.Security

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint

@ConditionalOnWebApplication
@Configuration
class CoreWebSecurityConfig {
    @Bean("authenticationEntryPoint")
    fun authenticationEntryPoint():AuthenticationEntryPoint{
        return Http403ForbiddenEntryPoint()
    }

}