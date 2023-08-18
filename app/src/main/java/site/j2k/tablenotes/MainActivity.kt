package site.j2k.tablenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import site.j2k.tablenotes.component.MainScreen
import site.j2k.tablenotes.ui.theme.TableNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableNotesTheme {
                MainScreen()
            }
        }
    }
}

