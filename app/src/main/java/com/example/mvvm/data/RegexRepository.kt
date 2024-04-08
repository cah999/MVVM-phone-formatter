package com.example.mvvm.data


class RegexRepository {
    fun getPhoneNumberRegex(): Regex {
        return Regex("^\\d{10}$")
    }
}