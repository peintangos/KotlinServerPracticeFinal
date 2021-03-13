package com.example.KotlinServerPracticeFinal.Security

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.session.SessionRegistry
import org.springframework.security.web.authentication.session.CompositeSessionAuthenticationStrategy
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy
import org.springframework.session.FindByIndexNameSessionRepository
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession
import org.springframework.session.security.SpringSessionBackedSessionRegistry

//@Configuration
//@EnableSpringHttpSession
//@ConditionalOnWebApplication
//class SessionConfig {
//    @Bean
//    fun sessionAuthenticationStrategy(sessionRegistry: SessionRegistry):SessionAuthenticationStrategy{
//        val sessionFicationProjectStrategy = SessionFixationProtectionStrategy()
//        sessionFicationProjectStrategy.setMigrateSessionAttributes(true)
//        sessionFicationProjectStrategy.setAlwaysCreateSession(true)
//        return CompositeSessionAuthenticationStrategy(listOf(sessionFicationProjectStrategy))
//    }
//    @Bean
//    @SuppressWarnings("rawtypes")
//    fun settionRegistry(sessionRepository: FindByIndexNameSessionRepository):SessionRegistry{
//        return SpringSessionBackedSessionRegistry(sessionRepository)
//    }
//}