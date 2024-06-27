package com.example.firstcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstComposeTheme {
                Scaffold(
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        PreviewItem()
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewItem(){

    LazyColumn(content = {
            items(getCategoryList()){
                BlogCategory(
                    img= it.img,
                    title = it.title,
                    subtitle = it.subtitle

                )
            }
    })


}

@Composable
fun BlogCategory(img: Int, title:String, subtitle: String){
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(6.dp)) {
            Row (verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)){

                Image(painter = painterResource(id = img), contentDescription ="",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .weight(.2f))
                ItemDescription(title, subtitle, Modifier.weight(.8f))
            }
    }

}

@Composable
fun ItemDescription(title: String, subtitle: String,modifier: Modifier) {
    Column(
        modifier =
        modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal

        )
    }
}



data class Category(val img: Int, val title:String, val subtitle: String)


fun getCategoryList() :  MutableList<Category>{
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.usercir,"Programming","Learn Every Language"))
    list.add(Category(R.drawable.user2,"Tech","Learn Every Tech"))
    list.add(Category(R.drawable.user3,"Career Counselling","There is always another way"))
    list.add(Category(R.drawable.user4,"Devops","No SE only Devops"))
    list.add(Category(R.drawable.user,"AI and ML","Curse or Boon for humanity"))
    list.add(Category(R.drawable.user,"Programming","Learn Every Language"))
    list.add(Category(R.drawable.user2,"Tech","Learn Every Tech"))
    list.add(Category(R.drawable.user3,"Career Counselling","There is always another way"))
    list.add(Category(R.drawable.user4,"Devops","No SE only Devops"))
    list.add(Category(R.drawable.user,"AI and ML","Curse or Boon for humanity"))
    list.add(Category(R.drawable.user3,"Career Counselling","There is always another way"))
    list.add(Category(R.drawable.user4,"Devops","No SE only Devops"))
    list.add(Category(R.drawable.user,"AI and ML","Curse or Boon for humanity"))
    list.add(Category(R.drawable.user,"Programming","Learn Every Language"))
    list.add(Category(R.drawable.user2,"Tech","Learn Every Tech"))
    list.add(Category(R.drawable.user3,"Career Counselling","There is always another way"))
    list.add(Category(R.drawable.user4,"Devops","No SE only Devops"))
    list.add(Category(R.drawable.user,"AI and ML","Curse or Boon for humanity"))

    return list
}
