package com.luismartingimeno.dogapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.luismartingimeno.dogapi.navigation.Navegacion
import com.luismartingimeno.dogapi.ui.theme.DOGAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DOGAPITheme {

                Navegacion()

            }
        }
    }
}