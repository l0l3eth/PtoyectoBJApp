package mx.tec.proyectoBJ.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import mx.tec.ptoyectobj.grisClaro
import mx.tec.ptoyectobj.morado
import mx.tec.ptoyectobj.negro

@Composable
fun PantallaPrincipalNegocio(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior() }
    ) { innerPadding ->
        Box(modifier = modifier.background(morado)
            .padding(innerPadding)) {
            NegocioNombre(nombre = "JÖTUNHEIM", descripcion = "Academia de Artes Marciales") 
        }
    }

}

@Composable
fun NegocioNombre(modifier: Modifier = Modifier,
                  nombre: String,
                  descripcion: String) {
    Text(nombre,
        modifier = modifier,
        style = TextStyle(
            color = negro,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold),
    )
    Text(descripcion,
        modifier = modifier,
        style = TextStyle(
            color = grisClaro,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun BarraSuperior(modifier: Modifier = Modifier) {
    
}

@Composable
fun BarraInferior(modifier: Modifier = Modifier) {
    
}