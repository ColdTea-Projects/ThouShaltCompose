package de.sample.naci.composetutorial.examples.preview

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SampleTextForPreview(){
    Text(text = "Sample text for preview")
}

//Vanilla preview
@Preview
@Composable
fun Preview1(){
    SampleTextForPreview()
}

// Add title
@Preview(
    name = "My sample preview 2",
    group = "Pieces"
)
@Composable
fun Preview2(){
    SampleTextForPreview()
}

// Show background
@Preview(
    name = "My sample preview 3",
    showBackground = true,
    backgroundColor = 0x940543,
    group = "Pieces"
)
@Composable
fun Preview3(){
    SampleTextForPreview()
}

// Show system ui
@Preview(
    name = "My sample preview 4",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
    group = "Full screen"
)
@Composable
fun Preview4(){
    SampleTextForPreview()
}


// Add dimensions
@Preview(
    name = "My sample preview 5",
    widthDp = 20,
    heightDp = 20,
    group = "Pieces"
)
@Composable
fun Preview5(){
    SampleTextForPreview()
}

//Night mode

@Preview(
    name = "My sample preview night mode 1",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
    group = "Full screen",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PreviewN1(){
    SampleTextForPreview()
}

@Preview(
    name = "My sample preview night mode 2",
    showBackground = true,
    group = "Pieces"
)
@Composable
fun PreviewN2(){
    SampleTextForPreview()
}
