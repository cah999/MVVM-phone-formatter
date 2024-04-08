package com.example.mvvm.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.RegexRepository
import com.example.mvvm.domain.model.PhoneNumber
import com.example.mvvm.domain.usecase.FormatPhoneNumberUseCase

class PhoneNumberViewModel : ViewModel() {
    private val useCase = FormatPhoneNumberUseCase(RegexRepository())
    val phoneNumberState: MutableState<String> = mutableStateOf("")
    val formattedPhoneNumber: MutableState<String> = mutableStateOf("")

    fun formatPhoneNumber() {
        val formattedNumber = useCase.execute(PhoneNumber(phoneNumberState.value))
        formattedPhoneNumber.value = formattedNumber
    }
}