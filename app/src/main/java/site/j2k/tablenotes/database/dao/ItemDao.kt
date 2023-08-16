package site.j2k.tablenotes.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import site.j2k.tablenotes.database.model.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM item WHERE boardID = :boardID")
    fun getAllByBoardID(boardID: Int): Flow<List<Item>>

    @Update
    suspend fun updateBoard(item: Item)

    @Insert
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: Item)
}