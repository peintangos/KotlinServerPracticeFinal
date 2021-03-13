package com.example.KotlinServerPracticeFinal.Util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.Getter
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
@Getter
class JacksoHelper {
    private lateinit var defautMapper:ObjectMapper

    @PostConstruct
    public fun postConstruct(){
        defautMapper = ObjectMapper()
        defautMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION,false)
        defautMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
    }
}