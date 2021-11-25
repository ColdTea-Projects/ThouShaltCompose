package de.sample.naci.composetutorial.gamepager.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import de.sample.naci.composetutorial.R
import de.sample.naci.composetutorial.gamepager.data.model.Result

@Composable
fun GameItem(game: Result) {
    Card(
        elevation = 20.dp,
        backgroundColor = Color.Black,
        modifier =
        Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .height(250.dp)
            .fillMaxWidth()
    ) {
        ConstraintLayout {
            val (image, title, rating) = createRefs()
            Image(
                contentScale = ContentScale.Crop,
                painter =
                    rememberImagePainter(
                        data = game.backgroundImage,
                        builder = {
                            placeholder(
                                R.drawable
                                    .ic_gaming_24
                            )
                            crossfade(true)
                        }
                    ),
                contentDescription = "Image",
                modifier =
                    Modifier.constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .height(150.dp)
                        .fillMaxWidth()
            )
            Text(
                text = game.name.orEmpty(),
                color = Color(0xFFF50057),
                maxLines = 2,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier =
                    Modifier.constrainAs(title) {
                            top.linkTo(image.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                        .padding(8.dp)
            )
            Row(
                modifier =
                    Modifier.fillMaxWidth().constrainAs(
                            rating
                        ) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(
                    text = game.rating.toString(),
                    color = Color(0xFFFFC400),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 18.sp
                )
                Image(
                    contentScale = ContentScale.Crop,
                    painter =
                        painterResource(
                            id = R.drawable.ic_star
                        ),
                    contentDescription = "Star",
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}

