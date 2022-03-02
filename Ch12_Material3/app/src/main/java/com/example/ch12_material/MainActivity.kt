package com.example.ch12_material

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ch12_material.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val tabName = listOf<String>("게시판", "메모장", "캘린더")

    lateinit var toggle: ActionBarDrawerToggle

    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init {
            fragments= listOf(OneFragment(), TwoFragment(), ThreeFragment())
        }
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add......................................
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened,
                R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewpager){ tab, position ->
            //리스트를 이용해 별도의 이름 부여
            tab.text = tabName.get(position)
        }.attach()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            when(it.itemId) {
                2131230944 -> {
                    Log.d("financeRyu", "아이템1")
                }

                2131230945 -> {
                    Log.d("financeRyu", "아이템2")
                    val fragmentManager: FragmentManager = supportFragmentManager
                    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                    val fragment = TwoFragment()
                    Log.d("financeRyu", "이까지옮")
                    transaction.replace(R.id.viewpager, fragment)
                    Log.d("financeRyu", "이까지옮2")
                }

                2131230946 -> {
                    Log.d("financeRyu", "아이템3")
                }

                2131230947 -> {
                    Log.d("financeRyu", "아이템4")
                }

            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //이벤트가 toggle 버튼에서 제공된거라면..
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}