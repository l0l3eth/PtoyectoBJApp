package mx.tec.proyectoBJ.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.tec.ptoyectobj.blanco
import mx.tec.ptoyectobj.gris
import mx.tec.ptoyectobj.grisClaro
import mx.tec.ptoyectobj.morado
import mx.tec.ptoyectobj.negro
import mx.tec.ptoyectobj.view.TextoTitular

// 1. Create an enum to represent the screens for type-safety
enum class Pantallas {
    Inicio,
    Promociones,
    Folio
}

@Composable
fun PantallaPrincipalNegocio(modifier: Modifier = Modifier) {
    // 2. State to track the currently selected screen
    var pantallaActual by remember { mutableStateOf(Pantallas.Inicio) }

    Scaffold(
        topBar = { BarraSuperior() },
        // 3. Pass the current state and the lambda to update it
        bottomBar = {
            BarraInferior(
                pantallaActual = pantallaActual,
                onPantallaSeleccionada = { nuevaPantalla ->
                    pantallaActual = nuevaPantalla
                }
            )
        }
    ) { innerPadding ->
        // 4. Show the correct screen based on the state
        when (pantallaActual) {
            Pantallas.Inicio -> Inicio(innerPadding)
            Pantallas.Promociones -> Promociones(modifier = modifier,
                innerPadding)
            Pantallas.Folio -> Folio(modifier = modifier,
                paddingValues = innerPadding)
        }
    }
}

@Composable
fun Inicio(innerPadding: PaddingValues, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(grisClaro)
            .padding(innerPadding)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(16.dp)
        ) {
            NegocioNombre(
                nombre = "JÖTUNHEIM",
                descripcion = "Academia de Artes Marciales",
            )
        }
    }
}

@Composable
fun Promociones(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    Column (modifier = modifier.padding(paddingValues)) {
        TextoTitular("Promociones")
    }
}

@Composable
fun Folio(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    Column (modifier = modifier.padding(paddingValues)) {
        TextoTitular("Folio")
    }
}

@Composable
fun NegocioNombre(modifier: Modifier = Modifier,
                  nombre: String,
                  descripcion: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            nombre,
            modifier = modifier,
            style = TextStyle(
                color = negro,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            ),
        )
        Text(
            descripcion,
            modifier = modifier,
            style = TextStyle(
                color = gris,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun BarraSuperior(modifier: Modifier = Modifier) {
    // 1. Define the custom shape for the corners
    val topBarShape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomEnd = 24.dp, // Adjust the rounding as you like
        bottomStart = 24.dp
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(topBarShape) // 2. Apply the custom shape
            .background(morado) // Use your color
            .padding(horizontal = 8.dp, vertical = 32.dp),
        verticalAlignment = Alignment.CenterVertically // Align items vertically
    ) {
        // 3. The button on the far left
        IconButton(onClick = { /* Abrir menú lateral */ }) {
            Icon(
                imageVector = Icons.Default.Menu, // Example icon
                contentDescription = "Menú",
                tint = negro // Use a visible color
            )
        }

        // 4. The text to the right of the button
        Text(
            text = "Bienvenido, negocio",
            modifier = Modifier
                .weight(1f) // Take up the remaining space
                .padding(end = 48.dp), // Balance the space taken by the icon
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = grisClaro,
                fontSize = 22.sp
            )
        )
    }
}

@Composable
fun BarraInferior(
    modifier: Modifier = Modifier,
    pantallaActual: Pantallas,
    onPantallaSeleccionada: (Pantallas) -> Unit
) {
    // A Box allows us to add padding around the Row, so it doesn't touch the edges
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp), // Padding to shrink the bar
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(32.dp)) // Fully rounded corners
                .background(blanco) // White background
                .padding(8.dp), // Inner padding for the buttons
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Reusable button for the navigation bar
            BotonNavegacion(
                texto = "Inicio",
                esSeleccionado = pantallaActual == Pantallas.Inicio,
                onClick = { onPantallaSeleccionada(Pantallas.Inicio) }
            )
            BotonNavegacion(
                texto = "Promociones",
                esSeleccionado = pantallaActual == Pantallas.Promociones,
                onClick = { onPantallaSeleccionada(Pantallas.Promociones) }
            )
            BotonNavegacion(
                texto = "Folio",
                esSeleccionado = pantallaActual == Pantallas.Folio,
                onClick = { onPantallaSeleccionada(Pantallas.Folio) }
            )
        }
    }
}

@Composable
fun BotonNavegacion(
    texto: String,
    esSeleccionado: Boolean,
    onClick: () -> Unit
) {
    // Determine colors based on selection state
    val colorFondo = if (esSeleccionado) morado else Color.Transparent
    val colorTexto = if (esSeleccionado) blanco else grisClaro

    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp), // Rounded shape for the button itself
        colors = ButtonDefaults.textButtonColors(containerColor = colorFondo),
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(
            text = texto,
            color = colorTexto,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BarraSuperiorPreview() {
    PantallaPrincipalNegocio()
}