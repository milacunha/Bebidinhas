package com.camilacunha.bebidinhas.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomIconsPresentation(
    val icon: ImageVector,
    val action: () -> Unit
)