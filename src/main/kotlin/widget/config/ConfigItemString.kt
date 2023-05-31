package widget.config

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun ConfigItemString(
    inputState: MutableState<String>,
    desc: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
) {
    OutlinedTextField(
        value = inputState.value,
        onValueChange = {
            inputState.value = it
        },
        label = { Text(desc) },
        modifier = modifier,
        singleLine = singleLine,
    )
}
