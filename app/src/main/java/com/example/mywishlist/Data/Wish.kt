package com.example.mywishlist.Data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
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