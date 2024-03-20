package com.example.mvvm.domain.usecase

import com.example.mvvm.data.PhoneNumberRepository
import com.example.mvvm.domain.model.PhoneNumber

class FormatPhoneNumberUseCase(private val repository: PhoneNumberRepository) {
    fun execute(phoneNumber: PhoneNumber): String {
        return repository.formatPhoneNumber(phoneNumber.number)
    }
}