package com.example.mvvmarchdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val  dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = Repository(dao)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)


        mainViewModel.getQutes().observe(this, Observer {
            binding.quotes = it.toString()
        })
        binding.btnInsert.setOnClickListener {

            val quote = Quote(0,"sample text","sample author")
            mainViewModel.insertQuote(quote)
        }
    }
}