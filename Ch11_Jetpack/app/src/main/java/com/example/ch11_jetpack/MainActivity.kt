package com.example.ch11_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.ch11_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    //뷰 페이저 어댑터
    class MyFragmentPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {
            val fragments: List<Fragment>
            init {
                fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
                Log.d("financeRyu", "fragments size : ${fragments.size}")
            }
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]

        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)    //툴바 바인딩
        //ActionBarDrawerToggle버튼 적용, 두번째 매게변수는 토글 버튼으로 여닫는 드로어 객체
        //세번째 네번째 매개변수는 문자열 리소스로, 드로어가 열리거나 닫혔을때의 상태를 표현한 문자열
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //토글버튼 = 아이콘 나오게하는 함수
        toggle.syncState()
        //뷰 페이저에 어댑터 적용
        val adapter = MyFragmentPagerAdapter(this)
        //뷰페이저 방향 새로로
        //binding.viewpager.orientation = ViewPager2.ORIENTATION_VERTICAL
        binding.viewpager.adapter = adapter
    }
    
    //정적메뉴
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //inflater선언하고 menu/menu_main.xml에 있는 메뉴를 바인딩함.
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        //MenuItem 객체를 얻고 그 안에 포함된 SearchView 객체 획득
        val menuItem = menu.findItem(R.id.menu_search)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                //키보드의 검색 버튼을 클릭한 순간의 이벤트
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                //검색어 변경 이벤트
                Log.d("kkang", "search text : $query")
                return true
            }

        })
        return true
    }
    //onPreParedOPTIONMENU 동적메뉴를 생성할때 호출
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //오버 플로 메뉴 선택 될 때.
        when(item.itemId) {
            R.id.menu1 -> {
                Log.d("kkang", "menu1 click")
            }

            R.id.menu2 -> {
                Log.d("kkang", "menu2 click")
            }
            else -> super.onOptionsItemSelected(item)
        }

        //이벤트가 토글 버튼에서 발생하면
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)



    }

}