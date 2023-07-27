package com.yourcompany.bullseye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yourcompany.bullseye.screens.AboutScreen
import com.yourcompany.bullseye.screens.GameScreen
import com.yourcompany.bullseye.ui.theme.BullseyeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BullseyeTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          MainScreen()
        }
      }
    }
  }
}

@Composable
fun MainScreen() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "gamescreen") {
    composable("gamescreen") {
      GameScreen(
        onNavigateToAbout = { navController.navigate("about") }
      )
    }
    composable("about") { AboutScreen() }
  }
}
