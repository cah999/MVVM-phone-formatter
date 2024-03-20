package com.example.mvvm.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.PhoneNumberRepository
import com.example.mvvm.domain.model.PhoneNumber
import com.example.mvvm.domain.usecase.FormatPhoneNumberUseCase

class PhoneNumberViewModel : ViewModel() {
    private val repository = PhoneNumberRepository()
    private val useCase = FormatPhoneNumberUseCase(repository)
    val phoneNumberState: MutableState<String> = mutableStateOf("")
    val formattedPhoneNumberState: MutableState<String> = mutableStateOf("")

    fun formatPhoneNumber() {
        val formattedNumber = useCase.execute(PhoneNumber(phoneNumberState.value))
        formattedPhoneNumberState.value = formattedNumber
    }
}