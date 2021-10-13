package com.example.componentsbasicosjetpackcomposer06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentsbasicosjetpackcomposer06.ui.theme.ComponentsBasicosJetPackComposer06Theme



//Componentes básicos
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsBasicosJetPackComposer06Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var textoIntroducido by remember { mutableStateOf("")}
    var textoText by remember { mutableStateOf("Aplicación")}
    Column(
        modifier = Modifier.fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    )
    {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Imagen",
            contentScale = ContentScale.FillWidth
        )
        Text(
            //text = "Texto",
            text=textoText,
            style = TextStyle(
                color = Color.Blue,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ))

        TextField(
            value = textoIntroducido,
            onValueChange ={
                    nuevoTexto->textoIntroducido=nuevoTexto
            },
            label = {
                Text(text = "Introducir texto")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_android_black_24dp),
                    contentDescription ="icono" )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters
            )
        )

        Button(
            onClick = {
                textoText=textoIntroducido
            }
        )
        {
            Text(text = "OK")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComponentsBasicosJetPackComposer06Theme {
        Greeting("Android")
    }
}