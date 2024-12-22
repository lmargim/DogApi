package com.luismartingimeno.dogapi.Screens.HomeScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luismartingimeno.dogapi.scaffold.TopBar

@Composable
fun HomeScreen(
    nombreUsuario: String,
    navigateToLogin: () -> Unit,
    navigateToBreedDetail: (String, String) -> Unit,
    viewModel: BreedsViewModel = viewModel()
) {
    val lista by viewModel.breeds.observeAsState(emptyList())
    val progressBar by viewModel.progressBar.observeAsState(false)

    Scaffold(
        topBar = {
            TopBar(
                title = "DogApi",
                navigateToLogin = navigateToLogin
            )
        }
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            if (progressBar) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(lista) { breed ->
                        BreedItem(breed = breed, onClick = { navigateToBreedDetail(nombreUsuario,breed) })
                    }
                }
            }
        }
    }
}

@Composable
fun BreedItem(breed: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(breed) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = breed,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(4.dp)
        )
    }
}

