package com.camilacunha.bebidinhas.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.camilacunha.bebidinhas.R
import com.camilacunha.bebidinhas.ui.component.ImageBackground
import com.camilacunha.bebidinhas.ui.component.TextFormatMessage
import com.camilacunha.bebidinhas.ui.component.TextFormatTitle
import com.camilacunha.bebidinhas.ui.theme.BebidinhasTheme

@Composable
fun SplashScreen() {
    BebidinhasTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white)),
        ) {
            ImageBackground()
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center)
            ) {
                TextFormatTitle(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally),
                    fontSize = 36.sp,
                    lineHeight = 20.sp
                )
                TextFormatMessage(
                    text = stringResource(id = R.string.loading),
                    fontSize = 24.sp,
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}