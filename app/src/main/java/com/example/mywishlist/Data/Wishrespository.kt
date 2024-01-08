package com.example.mywishlist.Data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun addWish(wish: Wish){
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> =
        wishDao.getAllWishes() //Flow automatically use asynchronous methods i.e no need for suspend

    fun getAWishById(id:Long) : Flow<Wish>{
        return wishDao.getAWishById(id)
    }

    suspend fun updateAWish(wish:Wish){
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }
}