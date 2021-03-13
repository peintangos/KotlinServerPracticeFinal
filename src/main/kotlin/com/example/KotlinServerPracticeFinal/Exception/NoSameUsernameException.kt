package com.example.KotlinServerPracticeFinal.Exception

import java.lang.Exception

class NoSameUsernameException:Exception{
    constructor(msg:String):super(msg)
}