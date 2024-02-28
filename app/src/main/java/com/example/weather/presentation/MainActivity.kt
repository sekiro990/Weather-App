package com.example.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.presentation.ui.theme.DarkBlue
import com.example.weather.presentation.ui.theme.DeepBlue
import com.example.weather.presentation.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel:WeatherViewModel by viewModels()
    private lateinit var permissionLauncher:ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher=registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        setContent {
            WeatherTheme {
                Column(
                 modifier = Modifier
                     .fillMaxSize()
                     .background(DarkBlue)
                ) {
                    WeatherCard(state = viewModel.state, DarkBlue)
                    Spacer(modifier = Modifier.height(16.dp))
                    WeatherForecast(state = viewModel.state)
                }

        }
    }
}
}