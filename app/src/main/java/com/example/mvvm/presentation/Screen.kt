package com.example.mvvm.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screen() {
    val viewModel: PhoneNumberViewModel = viewModel(
        factory = ViewModelProvider.NewInstanceFactory()
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val phoneNumberState = remember { mutableStateOf("") }

        TextField(
            value = phoneNumberState.value,
            onValueChange = { phoneNumberState.value = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            onClick = {
                viewModel.phoneNumberState.value = phoneNumberState.value
                viewModel.formatPhoneNumber()
            },
        ) {
            Text("Format")
        }
        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = viewModel.formattedPhoneNumberState.value)
    }
}