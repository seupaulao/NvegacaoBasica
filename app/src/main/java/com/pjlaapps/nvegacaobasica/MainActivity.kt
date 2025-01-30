package com.pjlaapps.nvegacaobasica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pjlaapps.nvegacaobasica.ui.theme.NvegacaoBasicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          Surface { MainScreen() }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("details") { DetailsScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Text("Home Screen")

        Button(onClick = { navController.navigate("details") }) {
            Text("Go to Details")
        }
    }
}
@Composable
fun DetailsScreen(navController: NavController) {
    Column {
        Text("Details Screen")

        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar a tela anterior")
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.FIRST_SCREEN
    ) {
        composable<Routes.FIRST_SCREEN> {
            FirstScreen (
                onNextPage = {
                    navController.navigate(Routes.SECOND_SCREEN)
                }
            )
        }
        composable<Routes.SECOND_SCREEN> {
            FirstScreen (
                onNextPage = {
                    navController.popBackStack()
                   // navController.navigate(Routes.FIRST_SCREEN)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NvegacaoBasicaTheme {
        MainScreen()
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    NvegacaoBasicaTheme {
        Navigation()
    }
}