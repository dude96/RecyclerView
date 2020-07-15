package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var picD:ImageView
    private lateinit var titleD:TextView
    private lateinit var textD:TextView
    private lateinit var cvD:CardView
    private lateinit var rvD:RecyclerView
    private  lateinit var listadpter:RAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        picD = findViewById(R.id.ImageV)
        titleD = findViewById(R.id.TV1)
        textD = findViewById(R.id.TV2)
        cvD = findViewById(R.id.CardV)
        rvD = findViewById(R.id.RecyclerV)

        picD.setOnClickListener{
            val intent = Intent(this,TripInfo::class.java)
            startActivity(intent)
        }
        initRecyclerview()
        addDataSet()

    }
    private fun addDataSet(){
        val data1 = DataSource.dataUnits()
        listadpter.submitList(data1)
    }
    private fun initRecyclerview(){
        rvD.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            listadpter = RAdapter(DataList = ArrayList())
            adapter = listadpter
        }
    }
}
