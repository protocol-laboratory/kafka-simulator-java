package widget.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun TextLogger(
    contents: MutableState<List<String>>
): @Composable Unit {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        repeat(contents.value.size) {
            SelectionContainer {
                Text(contents.value[it])
            }
        }
    }
}
