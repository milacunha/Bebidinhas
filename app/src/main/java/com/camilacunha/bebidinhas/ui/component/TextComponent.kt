package com.camilacunha.bebidinhas.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.camilacunha.bebidinhas.R

@Composable
fun TextSearch(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = colorResource(id = R.color.white)
) {
    Text(
        text = text,
        fontFamily = FontFamily(
            Font(R.font.sourcesans, FontWeight.Normal)
        ),
        letterSpacing = (-0.24).sp,
        lineHeight = 20.sp,
        fontSize = 18.sp,
        textAlign = textAlign,
        color = color,
        modifier = modifier
    )
}

@Composable
fun TextFormatTitle(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 28.sp,
    lineHeight: TextUnit = 50.sp
) {
    Text(
        text = text,
        fontFamily = FontFamily(
            Font(R.font.yesevaone, FontWeight.Normal)
        ),
        letterSpacing = (-0.24).sp,
        lineHeight = lineHeight,
        fontSize = fontSize,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.main_red),
        modifier = modifier
    )
}

@Composable
fun TextFormatMessage(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = colorResource(id = R.color.main_red),
    fontSize: TextUnit = 18.sp,
    lineHeight: TextUnit = 50.sp
) {
    Text(
        text = text,
        fontFamily = FontFamily(
            Font(R.font.sourcesans, FontWeight.Normal)
        ),
        letterSpacing = (-0.24).sp,
        lineHeight = lineHeight,
        fontSize = fontSize,
        textAlign = TextAlign.Center,
        color = color,
        modifier = modifier

    )
}

@Composable
fun TextInformationTitle(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        fontFamily = FontFamily(
            Font(R.font.yesevaone, FontWeight.Normal)
        ),
        letterSpacing = (-0.24).sp,
        lineHeight = 20.sp,
        fontSize = 18.sp,
        color = colorResource(id = R.color.black),
        modifier = modifier
    )
}

@Composable
fun TextInformationDetails(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontFamily = FontFamily(
            Font(R.font.sourcesans, FontWeight.Normal)
        ),
        letterSpacing = (-0.24).sp,
        lineHeight = 20.sp,
        fontSize = 16.sp,
        color = colorResource(id = R.color.black),
        modifier = modifier
    )
}