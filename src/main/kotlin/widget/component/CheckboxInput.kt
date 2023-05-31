package widget.component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewShortCheckboxInput() {
    CheckboxInput(mutableStateOf(false), "test input")
}

@Composable
fun CheckboxInput(
    state: MutableState<Boolean>,
    desc: String,
) {
    Row(Modifier.padding(4.dp).height(40.dp)) {
        Box(
            Modifier.fillMaxHeight()
        ) {
            Text(
                desc,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center),
            )
        }
        Checkbox(
            state.value,
            onCheckedChange = {
                state.value = it
            }
        )
    }
}
