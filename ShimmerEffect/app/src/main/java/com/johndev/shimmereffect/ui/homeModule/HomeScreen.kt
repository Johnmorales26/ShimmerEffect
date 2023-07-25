package com.johndev.shimmereffect.ui.homeModule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.johndev.shimmereffect.R
import com.johndev.shimmereffect.common.entities.Movie
import com.johndev.shimmereffect.common.utils.UiState
import com.johndev.shimmereffect.ui.homeModule.components.MovieItem
import com.johndev.shimmereffect.ui.homeModule.components.ShimmerItem
import com.johndev.shimmereffect.ui.theme.AntiFlashWhiteColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    viewModel.getListNowPlaying()
    Scaffold(
        topBar = {
            Header()
        },
        content = { paddingValues ->
            Body(padding = paddingValues, viewModel = viewModel)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    CenterAlignedTopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
}

@Composable
fun Body(padding: PaddingValues, viewModel: HomeViewModel) {
    val nowPlaying: List<Movie> by viewModel.listNowPlaying.observeAsState(initial = emptyList())
    val uiState: UiState by viewModel.uiState.observeAsState(initial = UiState.Loading)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = dimensionResource(id = R.dimen.common_padding_min),
                horizontal = dimensionResource(id = R.dimen.common_padding_default)
            ),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.common_padding_min))
        ) {
            when (uiState) {
                UiState.Success -> {
                    items(nowPlaying.size) { item ->
                        MovieItem(movie = nowPlaying[item])
                    }
                }

                UiState.Error -> {
                    items(1) {
                        Text(text = stringResource(R.string.label_error))
                    }
                }

                UiState.Loading -> {
                    items(10) {
                        ShimmerItem(color = AntiFlashWhiteColor)
                    }
                }
            }
        }
    }
}

