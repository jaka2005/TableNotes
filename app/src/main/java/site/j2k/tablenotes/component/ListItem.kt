package site.j2k.tablenotes.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import site.j2k.tablenotes.ui.theme.TableNotesTheme

@Composable
fun ListItem(text: String) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 1.dp,
        modifier = Modifier
            .padding(all = 5.dp)
    ) {
        Text(
            text = text, maxLines = 1,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun PreviewListItem() {
    TableNotesTheme {
        ListItem(text = "Carrot")
    }
}