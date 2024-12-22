import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.luismartingimeno.dogapi.Screens.BreedDetailScreen.BreedDetailViewModel
import com.luismartingimeno.dogapi.scaffold.TopBar

@Composable
fun BreedDetailScreen(
    nombreUsuario: String,
    breed: String,
    viewModel: BreedDetailViewModel = viewModel(),
    onBackClick: () -> Unit
) {
    val breedImage by viewModel.breedImage.collectAsState()
    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(breed) {
        viewModel.fetchBreedImage(breed)
    }

    Scaffold(
        topBar = {
            TopBar(
                titulo = breed,
                nombreUsuario = nombreUsuario,
                navigateToLogin = onBackClick
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (breedImage == null) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(50.dp)
                )
            } else {
                AsyncImage(
                    model = breedImage,
                    contentDescription = "$breed Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }

            // Botón para cambiar la imagen
            Button(
                onClick = {
                    viewModel.fetchBreedImage(breed)
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Refrescar Imagen",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
