package com.example.mywishlist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.mywishlist.Data.WishDataBase
import com.example.mywishlist.Data.WishRepository

object Graph {
    lateinit var database: WishDataBase

    val wishRepository by lazy { //by lazy means that this repo will not be loaded in the beginning, It will only be
        //loaded when we access it, it makes performance better
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context:Context){
        database = Room.databaseBuilder(context, WishDataBase::class.java, "wishlist.db").build() //wishlist.db will now be
    // the name of the database inside out phone
    }
}