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
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import site.j2k.tablenotes.bottomBorder
import site.j2k.tablenotes.database.model.Board
import site.j2k.tablenotes.viewmodel.MainViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Board(board: Board, mainViewModel: MainViewModel = viewModel()) {
    Surface(
        shape = MaterialTheme.shapes.large,
        shadowElevation = 2.5.dp,
        modifier = Modifier.padding(all = 4.dp)
    ) {
        Column {
            Text(
                text = board.name, textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .bottomBorder(1.5.dp, MaterialTheme.colorScheme.secondary)
            )

            Spacer(modifier = Modifier.height(4.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {


                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(all = 5.dp)
                        .clickable { },
                ) {
                    BasicTextField(
                        value = mainViewModel.itemNameFieldText.value,
                        singleLine = true,
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 6.dp)
                            .width(IntrinsicSize.Min)
                            .onFocusChanged {
                                mainViewModel.itemNameFieldText.value =
                                    if (it.isFocused) "" else "+"
                            }
                            .onKeyEvent {
                                if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
//                                    TODO("Not yet implemented")
                                    true
                                }
                                false
                            },
                        onValueChange = {
                            mainViewModel.itemNameFieldText.value = it
                        },
                    )
                }
            }
        }
    }
}
