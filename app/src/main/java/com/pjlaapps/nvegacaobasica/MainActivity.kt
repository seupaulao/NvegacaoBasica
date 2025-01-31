package com.pjlaapps.nvegacaobasica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen")
        Button(onClick = { navController.navigate("details") }) {
            Text("Go to Details")
        }
    }
}
@Composable
fun DetailsScreen(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
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
            SecondScreen (
                onNextPage = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun basicoPreview() {
    NvegacaoBasicaTheme {
        MainScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun basicoArquivosSeparadosPreview() {
    NvegacaoBasicaTheme {
        Navigation()
    }
}