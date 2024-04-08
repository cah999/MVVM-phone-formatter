package com.example.mvvm.domain.usecase

import com.example.mvvm.data.RegexRepository
import com.example.mvvm.domain.model.PhoneNumber

class FormatPhoneNumberUseCase(private val repository: RegexRepository) {
    fun execute(phoneNumber: PhoneNumber): String {
        val regex = repository.getPhoneNumberRegex()
        val cleanNumber = phoneNumber.number
            .replace(" ", "")
            .removePrefix("+7")
            .removePrefix("8")
            .removePrefix("7")
            .replace("(", "")
            .replace(")", "")
            .replace("-", "")

        return if (cleanNumber.matches(regex)) {
            "+7 (${cleanNumber.take(3)}) ${cleanNumber.substring(3, 6)} ${
                cleanNumber.substring(6)
            }"
        } else {
            "Invalid phone number"
        }
    }
}