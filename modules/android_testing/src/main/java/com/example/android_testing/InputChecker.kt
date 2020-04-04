package com.example.android_testing

import java.lang.IllegalArgumentException

class InputChecker {
    fun isValid(text: String?): Boolean {
        if (text == null) throw IllegalArgumentException("Cannot be null")
        return (text.length >= 3) && text.matches("[a-zA-Z0-9]+".toRegex())
    }
}