package site.j2k.tablenotes.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "item",
    indices = [Index("id", unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = Board::class,
            parentColumns = ["id"],
            childColumns = ["boardID"]
        )
    ]
)
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val boardID: Long,
    val name: String
)
