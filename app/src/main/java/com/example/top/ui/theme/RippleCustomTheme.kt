package com.example.top.ui.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

public object RippleCustomTheme: RippleTheme{
    @Composable
    override fun defaultColor(): Color {
        return RippleTheme.defaultRippleColor(
            Orange,
            lightTheme = true
        )
    }

    @Composable
    override fun rippleAlpha(): RippleAlpha {
        return RippleTheme.defaultRippleAlpha(
            Orange,
            lightTheme = true
        )
    }

}