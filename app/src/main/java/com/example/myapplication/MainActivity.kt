package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->

                    // Create the NavController — manages the back stack
                    val navController = rememberNavController()

                    // Build the navigation graph with two destinations
                    NavHost(
                        navController = navController,
                        startDestination = Home  // Home is shown first
                    ) {

                        // Destination 1: Home screen
                        composable<Home> {
                            HomeScreen(onShowGreeting = { typedName ->
                                // Navigate to Greeting, passing the typed name as a route object
                                navController.navigate(Greeting(userName = typedName))
                            })
                        }

                        // Destination 2: Greeting screen
                        composable<Greeting> { backStackEntry ->
                            // Unpack the typed Greeting object from the back stack
                            val greeting: Greeting = backStackEntry.toRoute()
                            GreetingScreen(userName = greeting.userName)
                        }
                    }
                }
            }
        }
    }
}