package com.dev.freetoplay.presentation.component.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun NavigationDrawerItem(
    modifier: Modifier,
    iconPainter: Painter,
    contentDescription: String = "",
    iconColor: Color,
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    onclick: () -> Unit
) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onclick() }
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = contentDescription,
            tint = iconColor
        )
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }

}