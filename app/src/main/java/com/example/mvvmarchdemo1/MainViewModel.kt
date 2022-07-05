package com.example.mvvmarchdemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) :ViewModel(){

    fun getQutes():LiveData<List<Quote>>{
        return repository.getQuotes();
    }

     fun insertQuote(quote: Quote){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuote(quote)
        }
    }
}