package com.dev.freetoplay.presentation.theme.activity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.freetoplay.data.repository.GameRepositoryImpl
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* A special type of state holder, incharge of giving access to the business
* logic of the application, going to prepare the application data for presentation
* in a screen.
* - Larger life time
* - It can hold data even when configuration changes
* */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GameRepositoryImpl
): ViewModel() {

    private val _splashScreenVisible = mutableStateOf(value = false)
    val splashScreenVisible: State<Boolean>
        get() = _splashScreenVisible

    private val _games: MutableStateFlow<Resource<List<Game>>> =
        MutableStateFlow(value = Resource.Loading())
    val games: StateFlow<Resource<List<Game>>>
        get() = _games

    init {
         viewModelScope.launch {
             _splashScreenVisible.value = true
             _games.value = repository.getAllGames()
             _splashScreenVisible.value = false
         }
    }
}