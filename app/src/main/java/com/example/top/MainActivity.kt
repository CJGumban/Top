package com.example.top

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.top.ui.theme.Orange
import com.example.top.ui.theme.RippleCustomTheme
import com.example.top.ui.theme.TopTheme
import com.example.top.ui.theme.White
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopTheme {
                // A surface container using the 'background' color from the theme
                var isButtonVisible by remember {
                    mutableStateOf(false)
                }
                    LoginScreen(isButtonVisible)
                lifecycleScope.launch {
                    delay(3000L)
                    isButtonVisible = true

                }

            }
        }
    }
}



@Composable
fun LoginScreen(
    isButtonVisible: Boolean
) {

    Scaffold(
        containerColor = Orange,
        modifier = Modifier
            .imePadding()
            .fillMaxSize(),


    ) {
        innerPadding ->
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                /*.padding(top=20.dp)*/
        ) {

            Image(
                painter = painterResource(id = R.drawable.the_orange_platform_logo),
                contentDescription = "Top Logo",
                modifier = Modifier
                    .size(200.dp)
                    .weight(1f, true)

                    ,
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center




                /*.scale(1f)
                .padding(top = if (isButtonVisible) 10.dp else 10.dp)*/
            )
            val density = LocalDensity.current
            AnimatedVisibility(visible = isButtonVisible,
                modifier = Modifier
                    .weight(1f,true)
                    ,enter = slideInVertically {
                    // Slide in from 40 dp from the top.
                    with(density) { 40.dp.roundToPx() }
                } + expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Bottom
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()

                ){
                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .weight(1f, true)
                        .padding(bottom = 24.dp)


                    ,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    CompositionLocalProvider(LocalRippleTheme provides RippleCustomTheme) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp)
                                .height(50.dp)

                        ) {
                            Text(
                                text = "Log in",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "Sign up",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(32.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()


                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = "Contact Us",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                        TextButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = "English",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowDown,
                                contentDescription = "Language Dropdown",
                                tint = White,
                                modifier = Modifier.scale(0.8f)
                            )
                        }
                    }
                }
            }

        }
    }

}




@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    TopTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Orange
        ){
            LoginScreen(true)
        }

    }
}