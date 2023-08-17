package site.j2k.tablenotes.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import site.j2k.tablenotes.database.model.Board

@Dao
interface BoardDao {
    @Query("SELECT * FROM board")
    fun getAll(): Flow<List<Board>>

    @Insert
    fun insert(board: Board)

    @Delete
    fun delete(board: Board)
}