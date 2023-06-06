package com.example.med_check_app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import  androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            HomePage(navController = navController)
        }
        composable(route = Screen.MedicinPage.route){
            MedicinPage()
        }
        composable(route = Screen.ReminderPage.route){
            ReminderPage()
        }
        composable(route = Screen.OrderPage.route){
            OrderPage()
        }
    }
}