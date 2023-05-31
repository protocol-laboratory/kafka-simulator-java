package widget.config

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun ConfigItemPort(inputState: MutableState<String>, desc: String, errorState: MutableState<String>) {
    ConfigItemBase(
        inputState,
        desc,
        verify = {
            try {
                val aux = it.toInt()
                if (aux <= 0 || aux >= 65536) {
                    "port show be 1 ~ 65535"
                } else {
                    ""
                }
            } catch (e: Exception) {
                "port show be a number"
            }
        },
        errorState,
        true,
    )
}
