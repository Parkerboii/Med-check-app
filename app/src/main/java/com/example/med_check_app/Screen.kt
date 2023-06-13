package com.example.med_check_app

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object MedicinPage : Screen("medicin_page")
    object ReminderPage : Screen("reminder_page")
    object OrderPage : Screen("order_page")
    object DataScreen : Screen("data_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$args")
            }
        }
    }
}
