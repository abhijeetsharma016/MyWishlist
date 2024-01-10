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
    @ColumnInfo(name = "Wish-description")
    val description: String = ""
)
