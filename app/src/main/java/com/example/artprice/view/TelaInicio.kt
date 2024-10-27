package com.example.artprice.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artprice.R
import com.example.artprice.ui.theme.ArtPriceTheme


@Composable
fun TelaInicio(navController: NavController){
    InicioImage(
        titulo = stringResource(R.string.titulo),
        subtitulo = stringResource(R.string.subtitulo),
        navController = navController
    )
}

@Composable
fun InicioText(titulo: String,subtitulo: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(20.dp)
    ){
        Text(
            text = titulo,
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = modifier
        )
        Text(
            text = subtitulo,
            textAlign = TextAlign.Center,
            fontSize = 17.sp,
            color = Color.White,
            modifier = modifier
                .padding(20.dp)
        )
    }

}

@Composable
fun InicioImage(titulo: String, subtitulo: String, navController: NavController? = null, modifier: Modifier = Modifier){
    val imageModifier = Modifier
        .size(250.dp)

    Box (
        modifier = Modifier //Foi Adicionado o Box para centralizar a imagem, juntamente com o horizontalAlignment
            .fillMaxSize() //Pegar toda a tela
            .background(colorResource(R.color.principal))
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.imagem_inicio),
                contentDescription = null,
                modifier = imageModifier
            )
            InicioText(
                titulo = titulo,
                subtitulo = subtitulo,
                modifier = modifier
            )
            BtnInicio(
                navController = navController,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                modifier = modifier
            )
        }
    }
}

@Composable
fun  BtnInicio(navController: NavController?, colors: ButtonColors, modifier: Modifier) {
    Button(onClick = { navController?.navigate("precificacao") }, colors = colors, modifier = modifier) {
        Text(
            text = "Iniciar",
            fontSize = 24.sp,
            color = colorResource(R.color.principal),
            modifier = modifier
                .padding(15.dp,10.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true, name = "Preview")
@Composable
fun GreetingPreview() {
    ArtPriceTheme {
        InicioImage(
            titulo = stringResource(R.string.titulo),
            subtitulo = stringResource(R.string.subtitulo)
        )
    }
}