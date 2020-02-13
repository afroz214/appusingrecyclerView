package com.smartherd.appusingrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val item = ArrayList<Custom_class>()

        item.add(Custom_class("background_one", R.drawable.background_one))
        item.add(Custom_class("background_two", R.drawable.background_two))
        item.add(Custom_class("background_three", R.drawable.background_three))
        item.add(Custom_class("background_one", R.drawable.background_one))
        item.add(Custom_class("background_two", R.drawable.background_two))
        item.add(Custom_class("background_three", R.drawable.background_three))
        item.add(Custom_class("background_one", R.drawable.background_one))
        item.add(Custom_class("background_two", R.drawable.background_two))
        item.add(Custom_class("background_three", R.drawable.background_three))

        val adapter = Adapter(item, applicationContext)
        recycler.layoutManager = GridLayoutManager(applicationContext,2) as RecyclerView.LayoutManager?
        recycler.adapter = adapter


    }
}
