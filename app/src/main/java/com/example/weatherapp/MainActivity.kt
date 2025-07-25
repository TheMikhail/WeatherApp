package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.screens.MainCard
import com.example.weatherapp.screens.TabLayout
import com.example.weatherapp.ui.theme.WeatherAppTheme

const val API_KEY = "c402a47da5094269a5272805252407"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                    Image(
                        painter = painterResource(R.drawable.weather_bg),
                        contentDescription = "im1",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                    Column{
                        MainCard()
                        TabLayout()
                    }

            }
        }
    }
}
/*
@Composable
fun Greeting(name: String, context: Context) {
    val state = remember{
        mutableStateOf("Unknown")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(), contentAlignment = Alignment.Center){
            Text(text = "Temp in $name = ${state.value} C")
        }
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter){
            Button(onClick = {
                getResult(name,state, context)
            }, modifier = Modifier.padding(5.dp)
                .fillMaxWidth()

            ) {
                Text( text =  "Refresh")
            }
        }
    }
}

private fun getResult(city: String, state: MutableState<String>, context: Context){
    val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY&" +
            "q=$city" +
            "&aqi=no"

    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            responce->
            val obj = JSONObject(responce)
            state.value = obj.getJSONObject("current").getString("temp_c")
        },
        {
            error->
            Log.d("MyLog", "Error $error")
        }
    )
    queue.add(stringRequest)
}*/
