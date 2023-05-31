import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import constant.PixelConst

@Composable
@Preview
fun App() {
}

fun main() = application {
    MaterialTheme {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Kafka Simulator",
            state = rememberWindowState(size = PixelConst.appSize)
        ) {
            App()
        }
    }
}
