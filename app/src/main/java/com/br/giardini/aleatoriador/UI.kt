package com.br.giardini.aleatoriador

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import kotlin.random.nextInt


fun randomColor(): Color {
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    return Color(red, green, blue)
}



@Composable
fun UI() {

    var randomBGColor = randomColor()
    var luminosity = ((randomBGColor.red*299)+(randomBGColor.green*587)+(randomBGColor.blue*114))/10
    var number = Random.nextInt(until = 61)
    var clicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .clickable { clicked = !clicked }
            .fillMaxSize()
    ){
        Row {
            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(color = randomBGColor)
            ){
                Text(text = "Cor", fontSize = 30.sp,color= if (luminosity>50) Color.Black else Color.White, modifier = Modifier
                    .padding(0.dp, 10.dp)
                    .align(alignment = Alignment.TopCenter)
                )
                Text(color= if (luminosity>50) Color.Black else Color.White,text = "R> ${randomBGColor.red}\nG> ${randomBGColor.green}\nB> ${randomBGColor.blue}", modifier = Modifier
                    .width(109.dp)
                    .align(alignment = Alignment.Center)
                )
            }


            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(color = Color.DarkGray)
            ){
                Text(text = "Mega", fontSize = 30.sp,color= Color.White, modifier = Modifier
                    .padding(0.dp, 10.dp)
                    .align(alignment = Alignment.TopCenter)
                )
                Text(color= Color.White,text = number.toString(), fontSize = 50.sp, modifier = Modifier
                    .align(alignment = Alignment.Center)
                )
            }
        }
        Row {
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(1f)
                .background(color = Color.Gray)
            ){
                Text(text = "Dados", fontSize = 30.sp,color= Color.White, modifier = Modifier
                    .padding(0.dp, 10.dp)
                    .align(alignment = Alignment.TopCenter)
                )

                Text(text = Random.nextInt(1..6).toString(), fontSize = 30.sp,color= Color.White, modifier = Modifier
                    .padding(0.dp, 180.dp)
                    .align(alignment = Alignment.TopCenter)
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .background(color = Color.White)
            ){
                Text(text = Random.nextBoolean().toString(), fontSize = 30.sp,color= Color.Black, modifier = Modifier
                    .padding(0.dp, 180.dp)
                    .align(alignment = Alignment.TopCenter)
                )

                Text(text = clicked.toString(), fontSize = 30.sp, color = Color.Transparent, modifier = Modifier)
            }
        }


    }
}