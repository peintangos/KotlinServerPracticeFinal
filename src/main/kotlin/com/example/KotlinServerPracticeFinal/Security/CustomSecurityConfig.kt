package com.example.KotlinServerPracticeFinal.Security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.web.accept.AbstractMappingContentNegotiationStrategy

@EnableWebSecurity
class CustomSecurityConfig:WebSecurityConfigurerAdapter() {
    @Autowired
    private final lateinit var customAuthenticationProvider:CustomAuthenticationProvider
    @Autowired
    private final lateinit var customAuthenticationSuccessSuccessHandler: CustomAuthenticationSuccessHandler
    @Autowired
    private final lateinit var customAuthenticationFailureHandler: CustomAuthenticationFailureHandler
    @Autowired
    private final lateinit var logoutSuccessHandler: CustomLogoutSuccessHandler
    private final lateinit var customAuthenticationFilter: CustomAuthenticationFilter
//    @Autowired
//    private final lateinit var sessionStrategy: SessionAuthenticationStrategy

    override fun configure(http: HttpSecurity?) {
        customAuthenticationFilter = CustomAuthenticationFilter()
        customAuthenticationFilter.setAuthenticationManager(authenticationManagerBean())
        customAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessSuccessHandler)
        customAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler)
//        customAuthenticationFilter.setSessionAuthenticationStrategy(sessionStrategy)

        http!!.csrf().disable().authorizeRequests {
            it.antMatchers("/login").permitAll()
            it.anyRequest().authenticated()
        }.logout {
            it.logoutRequestMatcher(AntPathRequestMatcher("/logout","POST")).logoutSuccessHandler(logoutSuccessHandler)
        }.addFilter(customAuthenticationFilter)
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(customAuthenticationProvider)
    }
}