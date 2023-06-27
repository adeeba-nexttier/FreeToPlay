package com.dev.freetoplay.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.legacy.widget.Space
import com.dev.freetoplay.R
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.presentation.component.CarouselView
import com.dev.freetoplay.presentation.component.EmptyResult
import com.dev.freetoplay.presentation.component.GameCard
import com.dev.freetoplay.util.Resource
import com.dev.freetoplay.util.header

@Composable
fun HomeScreen(
    onOpenDrawer: () -> Unit,
    onSearchButtonClick: () -> Unit,
    availableGames: Resource<List<Game>>
) {
    availableGames.data?.let { games ->
        if (games.isEmpty()) {
            EmptyResult(
                textId = R.string.wrn_no_games
            )
        }
        else {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { onOpenDrawer() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                    IconButton(onClick = { onSearchButtonClick() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_magnifying_glass_solid),
                            contentDescription = "",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }

                LazyVerticalGrid(columns = GridCells.Fixed(count = 2)) {
                    header {
                        CarouselView(
                            modifier = Modifier
                                .requiredHeight(height = 260.dp)
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 12.dp),
                            urls = ,
                            shape = MaterialTheme.shapes.medium,
                            crossFade = 1000
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                    items(items = games) { game ->
                        GameCard()
                    }
                }
            }
        }
    }
}