package com.example.ch17_database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch17_database.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var datas: MutableList<String>? = null
    lateinit var adapter: MyAdapter
    var lastId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("financeRyu", "onCreate do")
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select * from TODO_TB ORDER BY _ID DESC", null)
        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
        {
            it.data!!.getStringExtra("result")?.let {
                Log.d("financeRyu", "requestLauncher do")
                Log.d("financeRyu", "$datas")
                Log.d("financeRyu", "$it")
                datas?.add(it)
                adapter.notifyDataSetChanged()
            }
        }
        binding.mainFab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }
        datas= mutableListOf<String>()
        //add......................
        cursor.run{
            while(moveToNext()) {
                datas?.add(cursor.getString(0) + " : " + cursor.getString(1))
            }
        }
        db.close()

        println(datas!![0])

        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager=layoutManager
        adapter=MyAdapter(datas)
        binding.mainRecyclerView.adapter=adapter
        binding.mainRecyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId===R.id.menu_main_setting){
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onStart() {
        super.onStart()
        Log.d("financeRyu", "onStart do")
    }

    override fun onResume() {
        super.onResume()
        Log.d("financeRyu", "onStart do")
    }

}