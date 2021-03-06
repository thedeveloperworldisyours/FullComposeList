package com.a.jetpackcomposelists.expandable

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.R
import com.a.jetpackcomposelists.expandable.Constants.COLLAPSE_ANIMATION
import com.a.jetpackcomposelists.expandable.Constants.EXPAND_ANIMATION
import com.a.jetpackcomposelists.expandable.Constants.FADE_IN_ANIMATION
import com.a.jetpackcomposelists.expandable.Constants.FADE_OUT_ANIMATION

@ExperimentalAnimationApi
@Composable
fun ExpandableElement(
    modifier: Modifier,
    expandableViewModel: ExpandableViewModel,
    context: Context
) {
    val expandedItem = expandableViewModel.expandedList.collectAsState()
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = expandableViewModel.getElement(context)) { index, item: Element ->
            ExpandableCard(
                element = item,
                onCardArrowClick = { expandableViewModel.cardArrowClick(index) },
                expanded = expandedItem.value.contains(index)
            )
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ExpandableCard(
    element: Element,
    onCardArrowClick: () -> Unit,
    expanded: Boolean
) {
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor(
        { tween(durationMillis = EXPAND_ANIMATION) },
        label = "bgColorTransition"
    ) {
        if (expanded) Color.Blue else Color.Blue

    }
    val cardPaddingHorizontal by transition.animateDp(
        { tween(durationMillis = EXPAND_ANIMATION) },
        label = "paddingTransition"
    ) {
        20.dp
    }
    val cardElevation by transition.animateDp({
        tween(
            durationMillis = EXPAND_ANIMATION,
            easing = FastOutSlowInEasing
        )
    }, label = "elevation Transition") {
        20.dp
    }
    val cardRoundedCorners by transition.animateDp(
        {
            tween(
                durationMillis = EXPAND_ANIMATION,
                easing = FastOutSlowInEasing
            )
        },
        label = "corner Transition"
    ) {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(
            durationMillis = EXPAND_ANIMATION,
            easing = FastOutSlowInEasing
        )
    }, label = "corner Transition") {
        if (expanded) 0f else 180f
    }
    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = cardPaddingHorizontal,
                vertical = 8.dp
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = element.name,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .align(Alignment.CenterStart)
                )
                CardArrow(
                    degrees = arrowRotationDegree,
                    onClick = onCardArrowClick,
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.CenterEnd)
                )
            }
            ExpandableContent(expanded = expanded, element = element)
        }
    }
}


@Composable
fun CardArrow(
    modifier: Modifier,
    degrees: Float,
    onClick: () -> Unit
) {
    IconButton(modifier = modifier, onClick = onClick,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_expand_less_24),
                contentDescription = "Expandable Arrow",
                modifier = Modifier.rotate(degrees),
                tint = Color.White
            )
        }
    )
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent(expanded: Boolean = true, element: Element) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FADE_IN_ANIMATION,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(EXPAND_ANIMATION))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FADE_OUT_ANIMATION,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(COLLAPSE_ANIMATION))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
        ) {
            Text(
                text = element.detail,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                color = MaterialTheme.colors.primarySurface
            )
        }
    }
}
