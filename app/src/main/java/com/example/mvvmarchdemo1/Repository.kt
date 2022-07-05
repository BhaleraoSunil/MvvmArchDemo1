package com.example.mvvmarchdemo1

import androidx.lifecycle.LiveData

class Repository(val dao: QuoteDao) {

    fun getQuotes():LiveData<List<Quote>>{
        return dao.getQuotes();
    }


    suspend fun insertQuote(quote: Quote){

        dao.insertQuote(quote)

    }
}