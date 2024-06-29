package com.example.quotesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotesapp.models.Quote


@Composable
fun QuoteListScreen(data:  Array<Quote>, onClick: (quote:Quote) -> Unit){
    Column(){
            Card( shape = RectangleShape, modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
            ) {
                Text(text = "Quotes App",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(8.dp, 24.dp)
                        .fillMaxWidth(1f),
                    style = MaterialTheme.typography.headlineMedium) }
        QuoteList(data = data,onClick)
    }
}