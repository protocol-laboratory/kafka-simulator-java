package widget.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowPaddingButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        enabled = enabled,
        modifier = Modifier.padding(10.dp),
        content = content,
    )
}
