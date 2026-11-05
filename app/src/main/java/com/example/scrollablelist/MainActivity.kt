package com.example.scrollablelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrollablelist.data.DataSource
import com.example.scrollablelist.model.Bee
import com.example.scrollablelist.ui.theme.ScrollableListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollableListTheme {
                ScrollableList(DataSource().listItems())
            }
        }
    }
}

@Composable
fun BeeCard(bee: Bee, modifier: Modifier = Modifier){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = modifier){
        Column{
            Image(
                painter = painterResource(bee.drawableResId),
                contentDescription = stringResource(bee.stringResId),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(0.8f).aspectRatio(1f)
            )
            Text(
                text = stringResource(bee.stringResId),
                fontSize = 20.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}
@Composable
fun ScrollableList(list: List<Bee>) {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            ),
        color = Color(0xFFffd447)
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally){
            items(list){ bee ->
                BeeCard(bee = bee, modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Preview(widthDp = 1000, heightDp = 400, showBackground = true)
@Composable
fun ScrollableListPreview() {
    ScrollableListTheme {
        ScrollableList(DataSource().listItems())
    }
}