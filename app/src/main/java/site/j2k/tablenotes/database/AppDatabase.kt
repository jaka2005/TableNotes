package site.j2k.tablenotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import site.j2k.tablenotes.database.dao.BoardDao
import site.j2k.tablenotes.database.dao.ItemDao
import site.j2k.tablenotes.database.model.Board
import site.j2k.tablenotes.database.model.Item

@Database(
    version = 1, entities = [
        Board::class,
        Item::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract val boardDao: BoardDao
    abstract val itemDao: ItemDao

    companion object {
        fun createDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "database.db"
            ).allowMainThreadQueries().build()
        }
    }
}
