package de.sample.naci.composetutorial.examples

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.sample.naci.composetutorial.R
import java.io.FileDescriptor

@Composable
fun ImageCardTutorial() =
    Box(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .padding(10.dp)
    ) {
        ImageCard(
            painter = painterResource(id = R.drawable.darthkermit),
            contentDescripton = "Darth kermit talks to Kermit the frog",
            title = "Dew it!"
        )
    }

@Composable
fun ImageCard(
    painter: Painter,
    contentDescripton: String,
    title: String,
    modifier: Modifier = Modifier
) =
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(300.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescripton,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }

    }