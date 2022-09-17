package com.example.app_inapp_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_inapp_kotlin.adapter.ironmanAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ironmanList : ArrayList<Ironman>
    private lateinit var ironAdapter: ironmanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rcyIronman)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        ironmanList = ArrayList()

        ironmanList.add(Ironman("ironman mark 10", "10000", R.drawable.mohinhironman2))
        ironmanList.add(Ironman("ironman mark 50", "20000", R.drawable.mohinhironman3))
        ironmanList.add(Ironman("ironman mark 51", "50000", R.drawable.mohingironman4))
        ironmanList.add(Ironman("ironman mark 52", "90000", R.drawable.mohinhironman5))
        ironmanList.add(Ironman("ironman mark 10", "10000", R.drawable.mohinhironman2))
        ironmanList.add(Ironman("ironman mark 50", "20000", R.drawable.mohinhironman3))
        ironmanList.add(Ironman("ironman mark 51", "50000", R.drawable.mohingironman4))
        ironmanList.add(Ironman("ironman mark 52", "90000", R.drawable.mohinhironman5))
        ironmanList.add(Ironman("ironman mark 51", "50000", R.drawable.mohingironman4))
        ironmanList.add(Ironman("ironman mark 52", "90000", R.drawable.mohinhironman5))


        ironAdapter = ironmanAdapter(ironmanList)
        recyclerView.adapter = ironAdapter

        ironAdapter.onItemCick = {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("data", it)
            startActivity(intent)
        }


    }
}