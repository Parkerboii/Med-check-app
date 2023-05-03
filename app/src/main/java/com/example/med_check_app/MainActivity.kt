package com.example.med_check_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.med_check_app.ui.theme.MedcheckappTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedcheckappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        scaffoldState = scaffoldState,
                        modifier = Modifier.fillMaxSize(),
                        topBar = {TopBar()},
                        //bottomBar = { /*your bottom bar composable*/ }
                    ) {
                        Navigation()
                    }
                }

            }
        }
    }
}


@Composable
fun TopBar() {
    TopAppBar(title = {
        Text(
            text = "Medicin Appen",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,

        )
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MedcheckappTheme {
        TopBar()
        Navigation()
    }
}