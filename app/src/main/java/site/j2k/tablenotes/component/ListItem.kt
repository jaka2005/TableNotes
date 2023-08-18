package site.j2k.tablenotes.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import site.j2k.tablenotes.database.model.Item
import site.j2k.tablenotes.viewmodel.MainViewModel

@Composable
fun ListItem(item: Item, mainViewModel: MainViewModel = viewModel()) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 1.dp,
        modifier = Modifier
            .padding(all = 5.dp)
    ) {
        Text(
            text = item.name, maxLines = 1,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
