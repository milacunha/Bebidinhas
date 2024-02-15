package com.camilacunha.bebidinhas.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.camilacunha.bebidinhas.R
import com.camilacunha.bebidinhas.ui.component.ImageBackground
import com.camilacunha.bebidinhas.ui.component.TextFormatMessage
import com.camilacunha.bebidinhas.ui.component.TextFormatTitle
import com.camilacunha.bebidinhas.ui.theme.BebidinhasTheme

@Composable
fun ErrorScreen(
    errorMessage: String? = null,
    onClickTryAgain: () -> Unit
) {
    BebidinhasTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white)),
        ) {
            ImageBackground()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextFormatTitle(
                    text = stringResource(id = R.string.error_title),
                    modifier = Modifier.wrapContentSize(),
                    lineHeight = 20.sp
                )
                TextFormatMessage(
                    text = errorMessage ?: stringResource(id = R.string.error_message),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 12.dp)
                )
                Button(
                    onClick = onClickTryAgain,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 72.dp)
                        .wrapContentHeight(),
                    enabled = true,
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.main_red)
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    TextFormatMessage(
                        text = stringResource(id = R.string.try_again),
                        lineHeight = 20.sp,
                        color = colorResource(id = R.color.white),
                        modifier = Modifier.wrapContentSize()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    ErrorScreen(
        errorMessage = "Tente reiniciar o aplicativo",
        onClickTryAgain = {}
    )
}