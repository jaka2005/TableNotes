package site.j2k.tablenotes.component

import android.view.KeyEvent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import site.j2k.tablenotes.bottomBorder
import site.j2k.tablenotes.testListItems

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Board(name: String, rows: List<String>) {
    Surface(
        shape = MaterialTheme.shapes.large,
        shadowElevation = 2.5.dp,
        modifier = Modifier.padding(all = 4.dp)
    ) {
        Column {
            Text(
                text = name, textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .bottomBorder(1.5.dp, MaterialTheme.colorScheme.secondary)
            )

            Spacer(modifier = Modifier.height(4.dp))

            var text by remember { mutableStateOf(TextFieldValue("+")) }
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                rows.forEach { ListItem(it) }


                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(all = 5.dp)
                        .clickable { },
                ) {
                    BasicTextField(
                        value = text,
                        singleLine = true,
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 6.dp)
                            .width(IntrinsicSize.Min)
                            .onFocusChanged {
                                text = if (it.isFocused) {
                                    TextFieldValue("")
                                } else {
                                    TextFieldValue("+")
                                }
                            }
                            .onKeyEvent {
                                if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
//                                    TODO("Not yet implemented")
                                    true
                                }
                                false
                            },
                        onValueChange = {
                            text = it
                        },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBoard() {
    Board("Test Board", testListItems)
}