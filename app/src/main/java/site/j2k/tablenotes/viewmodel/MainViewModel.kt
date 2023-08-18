package site.j2k.tablenotes.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.Flow
import site.j2k.tablenotes.App
import site.j2k.tablenotes.database.AppDatabase
import site.j2k.tablenotes.database.model.Board
import site.j2k.tablenotes.database.model.Item

@Suppress("UNCHECKED_CAST")
class MainViewModel(private val db: AppDatabase) : ViewModel() {
    val boards: Flow<List<Board>> = db.boardDao.getAll()

    val items: Flow<List<Item>> = db.itemDao.getAll()

    val boardNameFieldText = mutableStateOf("New Table")
    val itemNameFieldText = mutableStateOf("+")
    val boardInFocus = mutableStateOf<Board?>(null)

    fun addNewBoard() {
        if (boardNameFieldText.value.isBlank()) return
        db.boardDao.insert(Board(name = boardNameFieldText.value))
        boardNameFieldText.value = ""
    }

    fun deleteBoard(board: Board) {
        db.boardDao.delete(board)
    }

    fun addNewItem() {
        if (boardInFocus.value == null || itemNameFieldText.value.isBlank()) return
        db.itemDao.insert(Item(boardID = boardInFocus.value?.id!!, name = itemNameFieldText.value))
        itemNameFieldText.value = ""
    }

    fun deleteItem(item: Item) {
        db.itemDao
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>, extras: CreationExtras,
            ): T {
                val db = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return MainViewModel(db) as T
            }
        }
    }
}
