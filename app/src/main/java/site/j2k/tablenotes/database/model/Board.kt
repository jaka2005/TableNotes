package site.j2k.tablenotes.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "board")
data class Board(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String
)
