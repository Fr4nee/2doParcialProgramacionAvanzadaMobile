import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.segundoparcial.ui.theme.SegundoParcialTheme


@Composable
fun ClimaPage(
    ciudad: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "$ciudad",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPagePreview() {
    SegundoParcialTheme {
        ClimaPage("")
    }
}