package com.example.artprice.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artprice.R

@Composable
fun Resultado(navController: NavController, resinas: Double, valor: Double, pesoPeca: Double, acessorios: Double, lucro: Double, taxas: Double){
    TelaResultado(
        text = stringResource(R.string.TituloTelaResultado),
        tema = stringResource(R.string.PrecificaçãoResultado),
        lucroTema = stringResource(R.string.LucroResultado),
        navController = navController,
        resinas = resinas,
        valor = valor,
        pesoPeca = pesoPeca,
        acessorios = acessorios,
        lucro = lucro,
        taxas = taxas
    )

}

@Composable
fun TelaResultado(text: String, tema: String, lucroTema: String, navController: NavController? = null, resinas: Double, valor: Double, pesoPeca: Double, acessorios: Double, lucro: Double, taxas: Double, modifier: Modifier = Modifier) {
    val resinaPeca = (valor / resinas) * pesoPeca
    val maoDeObra = (resinaPeca + acessorios) * lucro
    val resultado = resinaPeca + maoDeObra + lucro + taxas




    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.fundo))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = text,
                fontSize = 32.sp,
                modifier = modifier
                    .padding(top = 50.dp, bottom = 50.dp)
            )

            Column(
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(colorResource(R.color.white))
                    .padding(16.dp)
            ) {
                Text(
                    text = tema,
                    fontSize = 20.sp,
                    modifier = modifier
                        .padding(bottom = 10.dp)
                )
                Text(
                    text = lucroTema,
                    modifier = modifier
                        .padding(bottom = 20.dp)
                )

                ListaDeItens(
                    resinaPeca = resinaPeca,
                    maoDeObra = maoDeObra,
                    acessorios = acessorios,
                    resultado = resultado,
                    taxas = taxas
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            Button(
                onClick = {
                    if (navController != null) {
                        navController.navigate("precificacao")
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.principal)),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(0.6f)
            ) {
                Text(
                    text = "Novo Produto",
                    fontSize = 18.sp,
                    color = colorResource(R.color.white)
                )
            }
        }
    }
}

@Composable
fun ItemLista(nome:String, valor:String, icone:String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(colorResource(R.color.black)),
            contentAlignment = Alignment.Center
        ){
            Text(text = icone, color = Color.Red)
        }
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = nome,
            modifier = Modifier.weight(1f),
            style = androidx.compose.material3.MaterialTheme.typography.bodySmall
        )

        Text(
            text = valor,
            style = androidx.compose.material3.MaterialTheme.typography.bodySmall
        )

    }
}

@Composable
fun ListaDeItens(resinaPeca: Double, maoDeObra: Double, resultado: Double, acessorios: Double, taxas: Double){
    Column{
        val itens = listOf(
            Triple("Resina Por Peça", "$resinaPeca", "Icone 1"),
            Triple("Acessorios", "$acessorios", "Icone 2"),
            Triple("Mao de Obra", "$maoDeObra", "Icone 3"),
            Triple("Taxa", "$taxas", "Icone 4"),
            Triple("Total Venda", "$resultado", "Icone 5"),
        )

        itens.forEach {
            (nome, valor, icone) ->
            ItemLista(nome = nome, valor = valor, icone = icone)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, name = "Preview")
fun ResultadoPreview(){
    TelaResultado(
        text = stringResource(R.string.TituloTelaResultado),
        tema = stringResource(R.string.PrecificaçãoResultado),
        lucroTema = stringResource(R.string.LucroResultado),
        resinas = 0.0,
        valor = 0.0,
        pesoPeca = 0.0,
        acessorios = 0.0,
        lucro = 0.0,
        taxas = 0.0
    )
}