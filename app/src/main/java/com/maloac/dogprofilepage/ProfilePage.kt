package com.maloac.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage() {
    Card(elevation = 10.dp,
    modifier = Modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp, top = 100.dp, bottom = 100.dp)
        .border(width = 3.dp, color = Color.Red, shape = RoundedCornerShape(30.dp))) {
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Image(painter = painterResource(id = R.drawable.barber),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 3.dp, color = Color.Red, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(text = "Barber")
            Text(text = "Dominican Republic")

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)) {
                ProfileStats("Followers", "300")
                ProfileStats("Following", "150")
                ProfileStats("Posts", "40")
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Button(onClick = {}) {
                    Text(text = "Follow user")
                }

                Button(onClick = {}) {
                    Text(text = "Direct Menssage")
                }
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