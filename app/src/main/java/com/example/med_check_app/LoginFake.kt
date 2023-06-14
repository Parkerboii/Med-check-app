package com.example.med_check_app

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h4,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            placeholder = { Text(text = "Brugernavn") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray,
                textColor = Color.Black,
                placeholderColor = Color.Black
            )
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            placeholder = { Text(text = "Kodeord") },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray,
                textColor = Color.Black,
                placeholderColor = Color.Black
            )
        )
        Button(
            onClick = {
                //val route = Screen.LoginPage.getRoute() // Call the getRoute function on the Screen object
                // Navigate to the route using your navigation logic
            },
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.button,
                color = Color.White
            )
        }
        Text(
            text = "Glemt login?",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
            modifier = Modifier.padding(top = 50.dp)
        )
        Text(
            text = "Hjælp til login",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}



