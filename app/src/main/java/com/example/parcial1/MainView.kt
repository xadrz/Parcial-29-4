package com.example.parcial1


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun BilleteraView(modifier: Modifier = Modifier){
    /*necesito
    
    mostrar comprobante
     */

    val dinero = remember { mutableStateOf(10000L) }
    val retiro = remember {mutableStateOf(0L)}
    val retiroTexto = remember { mutableStateOf("0") }


    Column(modifier = modifier.fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
         Text(
             text = "Billetera",
             style = MaterialTheme.typography.titleLarge
         )

        Text(
            text = "${dinero.value}",
            style = MaterialTheme.typography.titleLarge
        )
        TextField(
            value = retiroTexto.value,
            onValueChange = { nuevoTexto ->
                retiroTexto.value = nuevoTexto

                // Intentar convertir a número
                val valor = nuevoTexto.toLongOrNull()
                if (valor != null) {
                    retiro.value = valor
                }
            })

            if(retiro.value <= dinero.value) {
                Button(onClick = {


                    dinero.value -= retiro.value

                }
                )
                {
                    Text("Retirar")
                }
            }
                else{
                Button(onClick = {}
                )
                {
                    Text("Error")
                }
                }

        



    }

}


@Preview(showBackground = true)
@Composable
fun BilleteraPreview()
{
    BilleteraView()
}