package com.example.kotlin_application

import android.content.ContentValues.TAG
import android.icu.text.NumberFormat
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import androidx.compose.ui.unit.sp
import com.example.kotlin_application.ui.theme.Kotlin_ApplicationTheme
import com.example.kotlin_application.ui.theme.Purple40
import com.example.kotlin_application.ui.theme.Purple80
import java.util.Locale
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_ApplicationTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var counter_card by remember{ mutableStateOf(1) }
    var counter_text by remember{ mutableStateOf(1) }

    var cardNum = when(counter_card){
        1->R.drawable.snuby
        else->R.drawable.wukong
    }
    var textNum = when(counter_text){
        1->"This is snuby!!!"
        else->"This is wukong!!!"
    }

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center){
        Landscape(cardNum)
        Spacer(modifier = Modifier.height(100.dp))
        textAndButton(textNum,{
            if(counter_card<=1&&counter_text<=1){}
            else{
                counter_card--
                counter_text--
            }
        },
            {
                if(counter_card>=2&&counter_text>=2){}
                else{
                    counter_card++
                    counter_text++
                }
            })
    }
}

@Composable
fun Landscape(image:Int){
    var myImage = image
    Card(modifier = Modifier
        .width(300.dp)
        .height(450.dp),
         elevation = CardDefaults.cardElevation(10.dp)){
         Image(painter = painterResource(id = myImage),
             contentDescription = null,
             modifier = Modifier
                 .fillMaxSize()
                 .padding(30.dp),
             contentScale = ContentScale.Crop)
    }
}
@Composable
fun textAndButton(text:String,decrement:()->Unit = {},increament:()->Unit = {}){
    Column(modifier = Modifier
        .fillMaxHeight()
        .navigationBarsPadding(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(textAlign = TextAlign.Center,
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.fillMaxWidth().border(2.dp,Color.Black, RoundedCornerShape(5.dp)))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = (decrement),
                modifier = Modifier.padding(start = 50.dp)){
                Text(text = "Previous",
                    modifier = Modifier.width(100.dp),
                    textAlign = TextAlign.Center)
            }
            Button(onClick = (increament),
                modifier = Modifier.padding(end = 50.dp)){
                Text(text = "Next",
                    modifier = Modifier.width(100.dp),
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_ApplicationTheme {
        MyApp()
    }
}
