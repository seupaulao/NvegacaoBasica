package com.pjlaapps.nvegacaobasica

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object FIRST_SCREEN

    @Serializable
    object SECOND_SCREEN
}

