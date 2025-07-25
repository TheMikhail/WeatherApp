package com.example.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.Data.WeatherModel
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.BlueLigth
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun MainCard() {
    Log.d("Compose","MainCard")
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = BlueLigth
            ),
            elevation = CardDefaults.elevatedCardElevation(0.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "20 Jun 2022 13:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                        contentDescription = "im2",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = 3.dp, end = 8.dp)
                    )
                }
                Text(
                    text = "Madrid",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "23C",
                    style = TextStyle(
                        fontSize = 65.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = "im3",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "23C/12C",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(R.drawable.sync),
                            contentDescription = "im4",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun TabLayout() {
    Log.d("Compose","TabLayout")
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState(pageCount = { tabList.size })
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(
            start = 5.dp,
            end = 5.dp
        )
            .clip(RoundedCornerShape(5.dp))) {
        TabRow(
            containerColor = BlueLigth,
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(pos[tabIndex]),
                    height = 4.dp,
                    color = BlueLigth
                )
            },
                contentColor = Color.White
            ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text)
                    }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) {
                index ->
            LazyColumn(Modifier.fillMaxSize()) {
                itemsIndexed(
                    listOf(
                        WeatherModel(
                            "London",
                            "10:00",
                            "25C",
                            "Sunny",
                            "//cdn.weatherapi.com/weather/64x64/day/116.png",
                            "",
                            "",
                            ""
                        ),
                        WeatherModel(
                            "London",
                            "26/07/2022",
                            "",
                            "Sunny",
                            "//cdn.weatherapi.com/weather/64x64/day/116.png",
                            "26",
                            "12",
                            "infoinfoinfoinfo"
                        )
                    )
                ){
                   _ ,item -> ListItem(item)
                }


            }
        }
    }
}
