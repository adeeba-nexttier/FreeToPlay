package com.dev.freetoplay.presentation.screen.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.presentation.component.drawer.NavigationDrawer
import com.dev.freetoplay.presentation.component.drawer.NavigationDrawerItem
import com.dev.freetoplay.presentation.screen.home.HomeScreen
import com.dev.freetoplay.util.Resource
import com.intuit.sdp.R

@Composable
fun Index(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    availableGames: Resource<List<Game>>,
    onOpenDrawer: () -> Unit,
    onSearchButtonClick: () -> Unit,
    onGameClick: () -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        drawerShape = RectangleShape,
        drawerContent = {
            NavigationDrawer(
                header = {
                    Image(
                        modifier = Modifier.size(size = dimensionResource(id = R.dimen._250sdp)),
                        painter = painterResource(id = com.dev.freetoplay.R.drawable.ic_free_to_play_launcher),
                        contentDescription = "",
                        contentScale = ContentScale.FillHeight,
                        alignment = Alignment.Center
                    )
                },
                content = {
                    NavigationDrawerItem(
                        modifier = Modifier
                            .requiredHeight(45.dp)
                            .padding(5.dp),
                        iconPainter = painterResource(id = com.dev.freetoplay.R.drawable.ic_bars_staggered_solid),
                        iconColor = MaterialTheme.colors.primary,
                        text = stringResource(id = com.dev.freetoplay.R.string.lbl_home),
                        textStyle = MaterialTheme.typography.subtitle1,
                        textColor = MaterialTheme.colors.onBackground,
                        onclick = {
                            // Navigate to home screen
                        }
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    NavigationDrawerItem(
                        modifier = Modifier
                            .requiredHeight(45.dp)
                            .padding(5.dp),
                        iconPainter = painterResource(id = com.dev.freetoplay.R.drawable.ic_windows_brands),
                        iconColor = MaterialTheme.colors.primary,
                        text = stringResource(id = com.dev.freetoplay.R.string.lbl_pc_games),
                        textStyle = MaterialTheme.typography.subtitle1,
                        textColor = MaterialTheme.colors.onBackground,
                        onclick = {
                            // Navigate to pc games
                        }
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    NavigationDrawerItem(
                        modifier = Modifier
                            .requiredHeight(45.dp)
                            .padding(5.dp),
                        iconPainter = painterResource(id = com.dev.freetoplay.R.drawable.ic_window_maximize_solid),
                        iconColor = MaterialTheme.colors.primary,
                        text = stringResource(id = com.dev.freetoplay.R.string.lbl_web_games),
                        textStyle = MaterialTheme.typography.subtitle1,
                        textColor = MaterialTheme.colors.onBackground,
                        onclick = {
                            // Navigate to web games
                        }
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    NavigationDrawerItem(
                        modifier = Modifier
                            .requiredHeight(45.dp)
                            .padding(5.dp),
                        iconPainter = painterResource(id = com.dev.freetoplay.R.drawable.ic_arrow_trend_up_solid),
                        iconColor = MaterialTheme.colors.primary,
                        text = stringResource(id = com.dev.freetoplay.R.string.lbl_latest_games),
                        textStyle = MaterialTheme.typography.subtitle1,
                        textColor = MaterialTheme.colors.onBackground,
                        onclick = {
                            // Navigate to latest games
                        }
                    )
                }
            )
        }
    ) {innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Screen.HomeScreen.route,
        ) {
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(
                    onOpenDrawer = { onOpenDrawer() },
                    onSearchButtonClick = { onSearchButtonClick() },
                    onGameClick = { onGameClick() },
                    availableGames = availableGames
                )
            }
        }
    }
}