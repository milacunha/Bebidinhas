package com.camilacunha.bebidinhas.intent

sealed class BackIntent {
    object FirstTouch : BackIntent()
    object SecondTouch : BackIntent()
}