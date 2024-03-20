package com.example.mvvm.data


class PhoneNumberRepository {
    fun formatPhoneNumber(phoneNumber: String): String {
        val cleanNumber = phoneNumber
            .replace(" ", "")
            .removePrefix("+7")
            .removePrefix("8")
            .removePrefix("7")
            .replace("(", "")
            .replace(")", "")
            .replace("-", "")

        return if (cleanNumber.matches(Regex("^\\d{10}$"))) {
            "+7 (${cleanNumber.take(3)}) ${cleanNumber.substring(3, 6)} ${
                cleanNumber.substring(6)
            }"
        } else {
            "Invalid phone number"
        }
    }
}