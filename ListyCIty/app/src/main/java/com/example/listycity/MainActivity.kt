package com.example.listcity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listycity.ui.theme.ListyCityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val cityRepository = CityRepository()
        setContent {
            ListyCityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CityListScreen(
                        cities = cityRepository.cities,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun CityListScreen (
        cities: List<String>,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(cities) {
                    city -> CityRow(city = city)
            }
        }
    }

    @Composable
    fun CityRow(city: String) {
        Text (
            text = city,
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 14.dp)
        )
    }
}

class CityRepository {
    private val _cities = mutableStateListOf(
        "Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"
    )
    // Getter methid for a read-only list for the UI to display
    val cities: List<String>
        get() = _cities

    fun addCity(city: String) {
        _cities.add(city)
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListyCityTheme {
        Greeting("Android")
    }
}