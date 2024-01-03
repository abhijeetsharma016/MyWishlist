package com.example.mywishlist

sealed class Screen (val route:String){
    object HomeScreen: Screen("home_Screen")
    object AddScrean: Screen("add_Screen")
}