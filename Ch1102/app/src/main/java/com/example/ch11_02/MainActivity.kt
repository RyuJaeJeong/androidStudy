package com.example.ch11_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.example.ch11_02.databinding.ActivityMainBinding
import com.example.ch11_02.databinding.LayoutBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = LayoutBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //  <!--android:parentActivityName=".MainActivity"--> 혹은 메니 페스트파일에서 이를 선언해주는 방법도 있음.
    }
    
    
    //메뉴생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //업 버튼 클릭 시 자동으로 호출되는 함수 재정의
    override fun onSupportNavigateUp(): Boolean {
        Log.d("kkang", "onSupportNavigateUp")
        //액티비티 코드에서 업 버튼 생성
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}