package com.example.kotlin_application

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun MyApp(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            Card(
                "Text composable",
                "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f),
                myColor= Color(0xFFEADDFF)
            )
            Card(
                "Image composable",
                "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f),
                myColor = Color(0xFFD0BCFF)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Card(
                "Row composable",
                "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f),
                myColor = Color(0xFFB69DF8)
            )
            Card(
                "Column composable",
                "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f),
                myColor = Color(0xFFF6EDFF)
            )
        }
    }
}

@Composable
fun Card(message1:String = "",message2:String = "",modifier:Modifier = Modifier,myColor:Color){
    Column(modifier = modifier.fillMaxSize().background(myColor),
        verticalArrangement = Arrangement.Center
    ){
        Text(text = message1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
            )
        Text(text = message2)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_ApplicationTheme {
        MyApp()
    }
}
