package com.example.KotlinServerPracticeFinal.Util

import lombok.RequiredArgsConstructor
import org.springframework.security.core.GrantedAuthority

enum class SystemAuthority(authority: String) :GrantedAuthority{
    ROLE_USER("ROLE_USER") {
        override fun getAuthority(): String {
            return this.authority
        }
    },
    ROLE_ADMIN("ROLE_ADMIN") {
        override fun getAuthority(): String {
            return this.authority
        }
    }
}