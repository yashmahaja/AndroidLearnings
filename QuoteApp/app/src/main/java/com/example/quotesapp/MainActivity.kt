package com.example.quotesapp

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotesapp.screens.QuoteDetail
import com.example.quotesapp.screens.QuoteListScreen
import com.example.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
//            QuotesAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Box(modifier = Modifier.padding(innerPadding)) {
                        App()
                    }
                }
            }
//        }
//    }
//}


@Composable
fun App(){
if(DataManager.isDataLoaded.value){

    if(DataManager.currentPage.value == Pages.LISTING){
        QuoteListScreen(data = DataManager.data) {
DataManager.switchPages(it)
        }
    }else{
        DataManager.currentquote?.let { QuoteDetail(quote = it) }
    }

    }else{
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)) {
        Text(text = "Loading.....", style = MaterialTheme.typography.headlineMedium)
    }
}
}
enum class Pages{
    LISTING,
    DETAIL
}


