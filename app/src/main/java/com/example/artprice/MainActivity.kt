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
import com.example.artprice.view.Resultado
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
                    composable(
                        route = "resultado/{resina}/{valor}/{pesoPeca}/{acessorios}/{lucro}/{taxas}/{tipoLucro}"
                    ){ backStackEntry ->
                        val resinas = backStackEntry.arguments?.getString("resina")?.toDoubleOrNull() ?: 0.0
                        val valor = backStackEntry.arguments?.getString("valor")?.toDoubleOrNull() ?: 0.0
                        val pesoPeca = backStackEntry.arguments?.getString("pesoPeca")?.toDoubleOrNull() ?: 0.0
                        val acessorios = backStackEntry.arguments?.getString("acessorios")?.toDoubleOrNull() ?: 0.0
                        val lucro = backStackEntry.arguments?.getString("lucro")?.toDoubleOrNull() ?: 0.0
                        val taxas = backStackEntry.arguments?.getString("taxas")?.toDoubleOrNull() ?: 0.0
                        val tipoLucro = backStackEntry.arguments?.getString("tipoLucro")?.toString() ?: "Porcentagem"

                        Resultado(
                            navController = navController,
                            resinas = resinas,
                            valor = valor,
                            pesoPeca = pesoPeca,
                            acessorios = acessorios,
                            lucro = lucro,
                            taxas = taxas,
                            tipoLucro = tipoLucro

                        )
                    }
                }
            }
        }
    }
}
