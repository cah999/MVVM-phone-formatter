package com.example.mvvm.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
    val phoneNumber by viewModel.phoneNumberState
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = phoneNumber,
            onValueChange = { viewModel.phoneNumberState.value = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            onClick = {
                viewModel.formatPhoneNumber()
            },
        ) {
            Text("Format")
        }
        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = viewModel.formattedPhoneNumber.value)
    }
}