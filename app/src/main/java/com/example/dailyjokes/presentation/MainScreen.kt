package com.example.dailyjokes.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyListState
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.dailyjokes.R
import com.example.dailyjokes.presentation.theme.DailyJokesTheme


@Composable
fun WearApp() {
    DailyJokesTheme {
        val scalingLazyListState = rememberScalingLazyListState(initialCenterItemIndex = 0)
        Scaffold(
            timeText = {
                TimeText()
            },
            vignette = {
                Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                PositionIndicator(
                    scalingLazyListState = scalingLazyListState,
                )
            }
        ) {
            MainScreen(scalingLazyListState)
        }
    }
}


@Composable
fun MainScreen(scalingLazyListState: ScalingLazyListState) {
    val configuration = LocalConfiguration.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cat_laugh),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(2.dp)
                .alpha(0.6f)
        )
        ScalingLazyColumn(modifier = Modifier.fillMaxSize(), state = scalingLazyListState) {
            item {
                Column(
                    modifier = Modifier
                        .height(configuration.screenHeightDp.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Welcome to your daily\ndose of laughter!👋",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                    )
                    Text(
                        text = "Scroll down",
                        fontSize = 12.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
            item {
                Box(modifier = Modifier) {
                    Text(
                        text = "When putting cheese in a mousetrap, always leave room for the mouse.",
                        color = Color.White,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(configuration.screenHeightDp.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Meow! Meow! Meow!\n😆",
                        modifier = Modifier,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "See you tomorrow!",
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier
                    )

                }
            }
        }
    }
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}