package com.maloac.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage() {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 100.dp, bottom = 100.dp)
            .border(width = 3.dp, color = Color.Red, shape = RoundedCornerShape(30.dp))
    ) {
        ConstraintLayout {
            val (image,
                nameText,
                countryText,
                profileStats,
                buttonFollow,
                buttonDirectMessage
            ) = createRefs()

            val guideLine = createGuidelineFromTop(fraction = 0.05f)

            Image(
                painter = painterResource(id = R.drawable.barber),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 3.dp, color = Color.Red, shape = CircleShape)
                    .constrainAs(image) {
                        top.linkTo(guideLine)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )

            Text(text = "Barber",
                modifier = Modifier.constrainAs(nameText) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Text(text = "Dominican Republic",
                modifier = Modifier.constrainAs(countryText) {
                    top.linkTo(nameText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .constrainAs(profileStats) {
                        top.linkTo(countryText.bottom)
                    }
            ) {
                ProfileStats("Followers", "300")
                ProfileStats("Following", "150")
                ProfileStats("Posts", "40")
            }

            Button(onClick = {},
                modifier = Modifier.constrainAs(buttonFollow) {
                    top.linkTo(profileStats.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(buttonDirectMessage.start)
                    width = Dimension.wrapContent
                }
                ) {
                Text(text = "Follow user")
            }

            Button(onClick = {},
                modifier = Modifier.constrainAs(buttonDirectMessage) {
                    top.linkTo(profileStats.bottom)
                    start.linkTo(buttonFollow.end)
                    end.linkTo(parent.end)
                }
                ) {
                Text(text = "Direct Menssage")
            }

        }
    }
}

@Composable
fun ProfileStats(name: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = name, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}