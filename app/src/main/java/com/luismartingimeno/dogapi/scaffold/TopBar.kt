package com.luismartingimeno.dogapi.scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luismartingimeno.dogapi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    titulo: String,
    nombreUsuario: String,
    navigateToLogin: () -> Unit
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "LogoApi",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.weight(1f)
                )

                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .background(
                            color = Color(0xFFE6F1F7),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            width = 1.5.dp, // Borde delgado
                            color = Color(0xFFB0C7D4),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Hola, $nombreUsuario",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            letterSpacing = 0.5.sp
                        ),
                        color = Color(0xFF4A4A4A),
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = navigateToLogin) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}


