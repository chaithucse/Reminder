package com.techchai.reminder.ui.greeting

import android.widget.HorizontalScrollView
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.protobuf.ExperimentalApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.techchai.reminder.R

@ExperimentalApi
@Composable
fun Greetings() {
    // val pagerState = rememberPagerState(pageCount = 10, initialOffscreenLimit = 2)

}

/*
@Composable
fun GreetingTextTemplates() {

}

@ExperimentalApi
@Composable
fun GreetingCardsTemplates(pagerState: PagerState) {
 val items: List<ImageBitmap>

 HorizontalPager(state = pagerState) { page ->
 val (podcast, lastEpisodeDate) = items[page]
 GreetingCarousalItem(
 podcastImageUrl = podcast.imageUrl,
 lastEpisodeDate = lastEpisodeDate,
 onUnfollowedClick = { onPodcastUnfollowed(podcast.uri) },
 modifier = Modifier
 .padding(4.dp)
 .fillMaxHeight()
 )
 }
}


@Composable
fun GreetingCarousalItem() {
 Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
 ) {
 Box(
 Modifier
 .weight(1f)
 .align(Alignment.CenterHorizontally)
 .aspectRatio(1f)
 ) {
 Image(
 */
/* painter = imageItem,*//*

 contentDescription = null,
 contentScale = ContentScale.Crop,
 modifier = Modifier
 .fillMaxSize()
 .clip(MaterialTheme.shapes.medium),
 )

 ToggleFollowPodcastIconButton(
 onClick = */
/* *//*
,
 isFollowed = true, */
/* All podcasts are followed in this feed *//*

 modifier = Modifier.align(Alignment.BottomEnd)
 )
 }
 }
}

@Composable
fun ToggleFollowPodcastIconButton(
 isFollowed: Boolean,
 onClick: () -> Unit,
 modifier: Modifier = Modifier
) {
 IconButton(
 onClick = onClick,
 modifier = modifier
 ) {
 Icon(
 // TODO: think about animating these icons
 imageVector = when {
 isFollowed -> Icons.Default.Check
 else -> Icons.Default.Add
 },
 contentDescription = when {
 isFollowed -> stringResource(R.string.app_name)
 else -> stringResource(R.string.app_name)
 },
 tint = animateColorAsState(
 when {
 isFollowed -> LocalContentColor.current
 else -> Color.Black.copy(alpha = ContentAlpha.high)
 }
 ).value,
 modifier = Modifier
 .shadow(
 elevation = animateDpAsState(if (isFollowed) 0.dp else 1.dp).value,
 shape = MaterialTheme.shapes.small
 )
 .background(
 color = animateColorAsState(
 when {
 isFollowed -> MaterialTheme.colors.surface.copy(0.38f)
 else -> Color.White
 }
 ).value,
 shape = MaterialTheme.shapes.small
 )
 .padding(4.dp)
 )
 }
}*/