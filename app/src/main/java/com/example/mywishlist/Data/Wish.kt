package com.example.mywishlist.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "Wish-title")
    val title: String = "",
    @ColumnInfo(name = "Wish-title")
    val description: String = ""
)


object DummyWish{
    val wishList = listOf(
        Wish(title = "google watch", description = "Android Watch"),
        Wish(title = "Movie", description = "Horror"),
        Wish(title = "A Si-fi book", description = "Read a Si-fi book"),
        Wish(title = "Been Bag", description = "A comfy been bag to substitute for a chair"),

    )
}