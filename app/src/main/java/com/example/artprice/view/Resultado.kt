package com.example.artprice.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.artprice.R

@Composable
fun Resultado(navController: NavController){
    TelaResultado(
        text = stringResource(R.string.TituloTelaResultado),
        navController = navController
    )

}

@Composable
fun TelaResultado(text:String, navController: NavController? = null, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Column {
            Text(
                text = text,
                modifier = modifier
            )

        }
    }

}

@Composable
@Preview
fun ResultadoPreview(showBackground: Boolean = true, showSystemUi: Boolean = true){
    TelaResultado(
        text = stringResource(R.string.TituloTelaResultado)
    )
}