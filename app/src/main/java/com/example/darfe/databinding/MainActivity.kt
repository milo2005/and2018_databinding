package com.example.darfe.databinding

import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darfe.databinding.databinding.ActivityMainBinding
import com.example.darfe.databinding.models.Book
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val loading:ObservableBoolean = ObservableBoolean(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loading = loading
        loadBook()
    }

    fun loadBook(){
        thread {
            Thread.sleep(3000)
            runOnUiThread {
                binding.book = buildBook()
                loading.set(false)
            }
        }
    }

    fun buildBook():Book = Book().apply {
        name = "Android para Dummies"
        img = "https://miracomohacerlo.com/wp-content/uploads/2017/09/Android-1.jpg"
        date = Date()
        category = 2
    }
}
