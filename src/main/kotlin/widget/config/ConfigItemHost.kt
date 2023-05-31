package widget.config

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import util.ValidateUtil

@Composable
fun ConfigItemHost(inputState: MutableState<String>, desc: String, errorState: MutableState<String>) {
    ConfigItemBase(
        inputState,
        desc,
        verify = {
            if (ValidateUtil.isNotHost(it)) {
                "it's not a validate host"
            } else {
                ""
            }
        },
        errorState,
        true,
    )
}
