package com.johndev.shimmereffect.ui.homeModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johndev.shimmereffect.common.entities.Movie
import com.johndev.shimmereffect.common.utils.UiState
import com.johndev.shimmereffect.model.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _listNowPlaying = MutableLiveData<List<Movie>>()
    val listNowPlaying: LiveData<List<Movie>> = _listNowPlaying

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getListNowPlaying() {
        _uiState.value = UiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            val response = repository.getListNowPlaying()
            if (response != null) {
                _uiState.postValue(UiState.Success)
                _listNowPlaying.postValue(response.results)
            } else {
                _uiState.postValue(UiState.Error)
            }
        }
    }

}