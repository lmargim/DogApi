import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
        }
    }
}

