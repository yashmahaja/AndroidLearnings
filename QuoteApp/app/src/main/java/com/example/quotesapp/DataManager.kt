package com.example.quotesapp

import android.content.Context
import android.graphics.pdf.PdfDocument.Page
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.models.Quote
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {

    var data = emptyArray<Quote>()
    var currentquote : Quote? = null
    var currentPage = mutableStateOf(Pages.LISTING)

    val isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true

    }

    fun switchPages(quote: Quote?){
        if (currentPage.value == Pages.LISTING){
            currentquote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}