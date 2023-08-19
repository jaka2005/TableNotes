package site.j2k.tablenotes.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import site.j2k.tablenotes.bottomBorder
import site.j2k.tablenotes.viewmodel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)
) {
    val boards = mainViewModel.boards.collectAsState(initial = emptyList()).value

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(50.dp)
                    .bottomBorder(1.5.dp, MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                BasicTextField(
                    value = mainViewModel.boardNameFieldText.value,
                    singleLine = true,
                    onValueChange = {
                        mainViewModel.boardNameFieldText.value = it
                    },
                    keyboardActions = KeyboardActions {
                        mainViewModel.addNewBoard()
                    }
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(boards) {
                    Board(it)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
