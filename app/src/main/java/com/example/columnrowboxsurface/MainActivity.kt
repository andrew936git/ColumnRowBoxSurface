package com.example.columnrowboxsurface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import kotlin.random.nextLong

class MainActivity : ComponentActivity() {

    private val personList = listOf(
        Person("Алексей", 35000),
        Person("Екатерина", 40000),
        Person("Владимир", 20000),
        Person("Максим", 50000),
        Person("Николай", 45000),
        Person("Анастасия", 55000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Table()

        }
    }

    @Composable
    private fun Table() {
        Surface(
            modifier = Modifier
                .padding(top = 30.dp, start = 10.dp, end = 10.dp),
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray)


                ) {
                    Text(
                        text = "Данные по персоналу",
                        fontSize = 30.sp
                    )
                }

                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentColor = Color.Black,
                    color = Color.LightGray,
                    border = BorderStroke(2.dp, Color.Black)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Имя",
                            fontSize = 24.sp,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Зарплата", fontSize = 24.sp)
                    }

                    Row(
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Телефон",
                            fontSize = 24.sp,
                            modifier = Modifier.padding(end = 20.dp)
                        )
                    }
                }

                for (i in personList) {
                    Surface(
                        border = BorderStroke(2.dp, Color.Black),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(horizontalAlignment = Alignment.Start) {

                            Text(
                                text = i.name,
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )

                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Text(
                                text = i.salary.toString(),
                                fontSize = 18.sp
                            )

                        }

                        Column(horizontalAlignment = Alignment.End) {
                            randomNumber(i)
                            Text(
                                text = i.phone.toString(),
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .padding(end = 10.dp)
                            )

                        }
                    }
                }
            }
        }


    }

    private fun randomNumber(person: Person) {
        val random = Random
        val number = "+79" + random.nextLong(1000000000L..9999999999L).toString()
        person.phone = number
    }
}

