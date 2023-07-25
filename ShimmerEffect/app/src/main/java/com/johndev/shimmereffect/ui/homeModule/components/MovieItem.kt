package com.johndev.shimmereffect.ui.homeModule.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.johndev.shimmereffect.R
import com.johndev.shimmereffect.common.entities.Movie
import com.johndev.shimmereffect.common.utils.Constants.BASE_URL_IMAGES
import com.johndev.shimmereffect.ui.theme.AntiFlashWhiteColor

@Composable
fun MovieItem(movie: Movie) {
    Surface(
        color = Color.Transparent,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.common_padding_min)),
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.card_height))
    ) {
        Card(
            border = BorderStroke(2.dp, AntiFlashWhiteColor),
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize(Alignment.CenterStart)
                    .padding(horizontal = dimensionResource(id = R.dimen.common_padding_default)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.common_padding_min))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(3f), verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = movie.title,
                        Modifier
                            .fillMaxWidth(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = movie.overview,
                        Modifier
                            .fillMaxWidth(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                AsyncImage(
                    model = BASE_URL_IMAGES + movie.poster_path,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                )
            }
        }
    }
}