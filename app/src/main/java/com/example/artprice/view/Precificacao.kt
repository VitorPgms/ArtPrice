package com.example.artprice.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artprice.R
import com.example.artprice.ui.theme.ShapesEditText


@Composable
fun Precificacao(navController: NavController){
    TelaPrecificacao(
        text = "Precificação",
        value = "",
        onValueChange = {},
        modifier = Modifier,
        label = "Valor",
        navController = navController
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPrecificacao(navController: NavController? = null, text:String, value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier, label: String){
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.letra))
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                modifier = modifier
                    .padding(40.dp)
            )
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier
                    .fillMaxWidth(),
                label = { Text(text = "Resina") },
                placeholder = { Text(text = "1kg, 500g,100g")},
                maxLines = 1,
                shape = ShapesEditText.small,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(R.color.fundo),
                )
            )
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier
                    .fillMaxWidth(),
                label = { Text(text = "Valor") },
                placeholder = { Text(text = "Valor total de resina")},
                maxLines = 1,
                shape = ShapesEditText.small,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(R.color.fundo),
                )
            )
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier
                    .fillMaxWidth(),
                label = { Text(text = "Peso Peça") },
                placeholder = { Text(text = "Quantidade usado por peça")},
                maxLines = 1,
                shape = ShapesEditText.small,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(R.color.fundo),
                )
            )
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier
                    .fillMaxWidth(),
                label = { Text(text = "Acessorios") },
                placeholder = { Text(text = "Valor total dos Acessorios")},
                maxLines = 1,
                shape = ShapesEditText.small,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(R.color.fundo),
                )
            )
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier
                    .fillMaxWidth(),
                label = { Text(text = "Lucro") },
                placeholder = { Text(text = "Valor da Mão de Obra")},
                maxLines = 1,
                shape = ShapesEditText.small,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(R.color.fundo),
                )
            )
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 100.dp),
                label = { Text(text = "Taxa") },
                placeholder = { Text(text = "Taxa da Maquina")},
                maxLines = 1,
                shape = ShapesEditText.small,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(R.color.fundo),
                )
            )
            BtnPrecificacao(
                navController = navController,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.principal)
                ),
                modifier = modifier
            )
        }

    }
}

@Composable
fun BtnPrecificacao(navController: NavController?, colors: ButtonColors, modifier: Modifier){
    Button(onClick = { navController?.navigate("resultado") }, colors = colors, modifier = modifier) {
        Text(
            text = "Calcular",
            fontSize = 24.sp,
            color = colorResource(R.color.white),
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(15.dp, 10.dp)
        )
    }
}

@Composable
@Preview
private fun PrecificacaoPreview(showBackgroud: Boolean = true, showSystemUi: Boolean = true){
    TelaPrecificacao(
        text = "Precificação",
        value = "",
        onValueChange = {},
        modifier = Modifier,
        label = "Valor"
    )
}