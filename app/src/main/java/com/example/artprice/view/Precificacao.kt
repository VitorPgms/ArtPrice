package com.example.artprice.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artprice.R


@Composable
fun Precificacao(navController: NavController){
    TelaPrecificacao(
        text = "Precificação",
        modifier = Modifier,
        navController = navController,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.principal))
    )
}

@Composable
fun TelaPrecificacao(navController: NavController? = null, text:String, modifier: Modifier = Modifier, colors: ButtonColors){
    var resina by remember { mutableStateOf(0.0) }
    var valor by remember { mutableStateOf(0.0) }
    var peso by remember { mutableStateOf(0.0) }
    var acessorio by remember { mutableStateOf(0.0) }
    var lucro by remember { mutableStateOf(0.0) }
    var taxa by remember { mutableStateOf(0.0) }

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.letra))
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                modifier = modifier
                    .padding(40.dp)
            )

            ListaDeInformacoes(
                resina = resina,
                onResinaChange = { resina = it },
                valor = valor,
                onValorChange = { valor = it },
                pesoPeca = peso,
                onPesoPecaChange = { peso = it },
                acessorios = acessorio,
                onAcessoriosChange = { acessorio = it },
                lucro = lucro,
                onLucroChange = { lucro = it },
                taxas = taxa,
                onTaxasChange = { taxa = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController?.navigate("resultado/$resina/$valor/$peso/$acessorio/$lucro/$taxa") }, colors = colors, modifier = modifier) {
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

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemInformacao(titulo:String, desc:String, onValueChange: (Double) -> Unit){
    var descricao by remember { mutableStateOf("") }

    OutlinedTextField(
        value = descricao,
        onValueChange = {
                if (it.toDoubleOrNull() != null || it.isEmpty()) {
                    descricao = it
                    onValueChange(it.toDoubleOrNull() ?: 0.0)
                }
        },
        label = { Text(titulo) },
        placeholder = { Text(desc) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(R.color.black),
            unfocusedBorderColor = colorResource(R.color.letra),
            focusedLabelColor = colorResource(R.color.black),
            containerColor = colorResource(R.color.fundo)
        ),
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) //Faz com que o Outlined Receba o teclado numerico
    )
}

@Composable
fun ListaDeInformacoes(
    resina: Double,
    onResinaChange: (Double) -> Unit,
    valor: Double,
    onValorChange: (Double) -> Unit,
    pesoPeca: Double,
    onPesoPecaChange: (Double) -> Unit,
    acessorios: Double,
    onAcessoriosChange: (Double) -> Unit,
    lucro: Double,
    onLucroChange: (Double) -> Unit,
    taxas: Double,
    onTaxasChange: (Double) -> Unit
){

    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        ItemInformacao("Resina", "1kg,500g, 300g...", onValueChange = onResinaChange)
        ItemInformacao("Valor","Valor total da Resina", onValueChange = onValorChange)
        ItemInformacao("Peso Peça","Quantidade usada por peça", onValueChange = onPesoPecaChange)
        ItemInformacao("Acessorios","Valor Somado do Acessorio", onValueChange = onAcessoriosChange)
        ItemInformacao("Lucro","Porcentagem de lucro", onValueChange = onLucroChange)
        ItemInformacao("Taxas","Taxa da Maquina", onValueChange = onTaxasChange)
    }
}


@Composable
@Preview
private fun PrecificacaoPreview(showBackgroud: Boolean = true, showSystemUi: Boolean = true){
    TelaPrecificacao(
        text = "Precificação",
        modifier = Modifier,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.principal))
    )
}