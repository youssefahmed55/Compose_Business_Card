package com.example.composebusinesscard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.composebusinesscard.ui.theme.ComposeBusinessCardTheme
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.background_Color)
                ) {
                    ComposeBusinessCard()
                }
            }
        }
    }
}



@Composable
fun ComposeBusinessCard() {
    Column {
        CardNameAndSpecialist(name = "Youssef Ahmed", specialist = "Android Developer",Modifier.weight(1.5F))
        CardDetails(Modifier.weight(1F).padding(bottom = 45.sdp))
    }

}

@Composable
fun CardDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Divider(
            color = colorResource(id = R.color.divider_Color),
            modifier = Modifier.fillMaxWidth()
        )
        ComposeItem(
            Icons.Default.Phone,
            "+20 122 965 1459",
            stringResource(R.string.Phone_Icon),
            Modifier.padding(top = 10.sdp, bottom = 10.sdp, start = 50.sdp)
        )
        Divider(
            color = colorResource(id = R.color.divider_Color),
            modifier = Modifier.fillMaxWidth()
        )
        ComposeItem(
            Icons.Default.Share,
            "@YoussefAhmed505505",
            stringResource(R.string.Share_Icon),
            Modifier.padding(top = 10.sdp, bottom = 10.sdp, start = 50.sdp)
        )
        Divider(
            color = colorResource(id = R.color.divider_Color),
            modifier = Modifier.fillMaxWidth()
        )
        ComposeItem(
            Icons.Default.Email, "youssefahmed505505@gmail.com",
            stringResource(R.string.Email_Icon), Modifier.padding(top = 10.sdp, start = 50.sdp)
        )
    }
}

@Composable
fun ComposeItem(
    icon: ImageVector,
    text: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Start) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = colorResource(id = R.color.specialist_Color)
        )
        Text(text = text, color = Color.White, fontSize = 12.ssp, modifier = Modifier.padding(start = 10.sdp))
    }


}

@Composable
fun CardNameAndSpecialist(name: String, specialist: String,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(70.sdp)
                .height(50.sdp),
            painter = painterResource(id = R.drawable.andoird_image),
            contentDescription = stringResource(R.string.Android_Image)
        )
        Text(text = "android", fontSize = 20.ssp, color = Color.White)
        Text(
            text = name,
            modifier = Modifier.padding(top = 16.sdp),
            fontSize = 26.ssp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif
        )
        Text(
            text = specialist,
            color = colorResource(id = R.color.specialist_Color),
            fontWeight = FontWeight.Bold,
            fontSize = 16.ssp,
            modifier = Modifier.padding(top = 8.sdp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeBusinessCardPreview() {
    ComposeBusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.background_Color)
        ) {
            ComposeBusinessCard()
        }
    }
}