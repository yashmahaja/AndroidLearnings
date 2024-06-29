package com.example.darktheme

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.darktheme.ui.theme.DarkThemeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Theme()
        }
    }
}

@Composable
fun Theme() {
    var theme = remember {
        mutableStateOf(false)
    }
    
    DarkThemeTheme(theme.value){
        Column(verticalArrangement = Arrangement.Center, 
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            Text(text = "Toggling Themes")
            
//            Image(imageVector = Icons.Filled.WbSunny, contentDescription = "" ,
//                modifier = Modifier.clickable  {theme.value = !theme.value })
            Button(onClick ={theme.value = !theme.value }) {
                Text(text = "Change Theme")
            }
        }
    }
    
}
