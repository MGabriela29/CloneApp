package com.example.practica4to

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica4to.ui.screens.PracticeNavigationGraph
import com.example.practica4to.ui.screens.Routes
import com.example.practica4to.ui.screens.UserInputScreen
import com.example.practica4to.ui.screens.WelcomeScreen
import com.example.practica4to.ui.theme.Practica4toTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica4toTheme {
                PracticeApp()
            }
        }
    }
        @Composable
        fun PracticeApp(){
            PracticeNavigationGraph()
        }

}

