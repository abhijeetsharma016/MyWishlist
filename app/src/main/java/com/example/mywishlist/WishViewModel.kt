package com.example.mywishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlist.Data.Wish
import com.example.mywishlist.Data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository:WishRepository = Graph.wishRepository
):ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString: String) {
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String) {

        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>> //lateinit is a promiss we make to compiler that the var will

    // get time to setup i.e it will be initialised late and asynchronously
    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {//Decides what thread or threads the coroutine will run on
            //running the IO operation on main thread can block it and hence result in bad user experience
            wishRepository.addWish(wish = wish)
        }
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWishById(id = id)
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {//Decides what thread or threads the coroutine will run on
            //running the IO operation on main thread can block it and hence result in bad user experience
            wishRepository.updateAWish(wish = wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {//Decides what thread or threads the coroutine will run on
            //running the IO operation on main thread can block it and hence result in bad user experience
            wishRepository.deleteAWish(wish = wish)

        }
    }
}
