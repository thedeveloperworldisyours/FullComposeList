package com.a.jetpackcomposelists.swipe

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.ui.theme.Purple700
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun SwipeContent(name: String) {
    val squereSize = 150.dp
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val sizePx = with(LocalDensity.current) {
        squereSize.toPx()
    }
    val anchors = mapOf(0f to 0, sizePx to 1)
    val roundedCorner = 5.dp
    val sizeElement = 50.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(roundedCorner))
                .background(Color.White)
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    orientation = Orientation.Horizontal
                )
        ) {
            Row {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(sizeElement)
                        .clip(RoundedCornerShape(roundedCorner))
                        .background(Color.DarkGray)
                ) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = "Edit",
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(sizeElement)
                        .clip(RoundedCornerShape(roundedCorner))
                        .background(Color.Red)
                ) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = "Delete",
                        tint = Color.White
                    )
                }
            }
            Box(modifier = Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .clip(RoundedCornerShape(roundedCorner))
                .fillMaxWidth()
                .height(sizeElement)
                .fillMaxHeight()
                .background(Purple700)) {
                Text(
                    text = name,
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = Color.White
                )
            }
        }
    }
}