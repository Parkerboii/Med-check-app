package com.example.med_check_app

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.med_check_app.ui.theme.MedcheckappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedcheckappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(activity: ComponentActivity){
    topBar()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black),
            modifier = Modifier
                .width(300.dp)
                .padding(20.dp),
            onClick = {
                val MedicinPage = Intent(activity, MedicinPage::class.java)
                activity.startActivity(MedicinPage)
            }) {
            Text("Medicin", fontSize = 30.sp)

        }
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black),
            modifier = Modifier
                .width(300.dp)
                .padding(20.dp),
            onClick = { /*TODO*/ }) {
            Text("Påmindelser", fontSize = 30.sp)
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black),
            modifier = Modifier
                .width(300.dp)
                .padding(20.dp),
            onClick = { /*TODO*/ }) {
            Text("Bestil Medicin", fontSize = 30.sp)
        }
    }
}

@Composable
fun topBar() {
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
        HomeScreen(activity = ComponentActivity())
    }
}