package site.j2k.tablenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import site.j2k.tablenotes.ui.theme.TableNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Board("test board", testListItems)
                        Board("second test board", testListItems)
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(text: String) {
    Row(modifier = Modifier.padding(all = 5.dp)) {
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
            Text(
                text = text, maxLines = 1,
                modifier = Modifier.padding(all = 4.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewListItem() {
    TableNotesTheme {
        ListItem(text = "Carrot")
    }
}

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

            LazyColumn {
                items(rows) { content ->
                    ListItem(content)
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
