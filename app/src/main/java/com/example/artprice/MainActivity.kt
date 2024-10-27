package com.example.artprice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.artprice.ui.theme.ArtPriceTheme
import com.example.artprice.view.InicioText
import com.example.artprice.view.Precificacao
import com.example.artprice.view.TelaInicio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtPriceTheme {
                val navController = rememberNavController()

                //Criando uma rota de navegação entre as telas do app. A ordem do Comosable mostra a ordem das telas.
                NavHost(navController = navController, startDestination = "telaInicio"){
                    composable(
                        route = "telaInicio"
                    ){
                        TelaInicio(navController)
                    }
                    composable(
                        route = "precificacao"
                    ){
                        Precificacao(navController)
                    }
                }
            }
        }
    }
}
