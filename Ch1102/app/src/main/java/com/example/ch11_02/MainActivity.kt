package com.example.ch11_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch11_02.databinding.ItemMainBinding
import com.example.ch11_02.databinding.RecyclerviewBinding

class MyViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(val binding: ItemMainBinding): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = MyViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang", "onBindViewHolder : $position")
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = datas[position]
        binding.itemRoot.setOnClickListener{
            Log.d("kkang", "item root click : $position")
        }
    }
}

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = RecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datas = mutableListOf<String>()
        for (i in 1..10) {
            datas.add("Item $i")
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout Manager.VERTICAL))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //  <!--android:parentActivityName=".MainActivity"--> ?????? ?????? ????????????????????? ?????? ??????????????? ????????? ??????.
    }
    
    
    //????????????
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //??? ?????? ?????? ??? ???????????? ???????????? ?????? ?????????
    override fun onSupportNavigateUp(): Boolean {
        Log.d("kkang", "onSupportNavigateUp")
        //???????????? ???????????? ??? ?????? ??????
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}