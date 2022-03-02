package com.example.ch11_jetpack

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch11_jetpack.databinding.FragmentOneBinding
import com.example.ch11_jetpack.databinding.FragmentTwoBinding
import com.example.ch11_jetpack.databinding.ItemRecyclerviewBinding

//항목뷰 객체를 가지는 역활을 하는 뷰 홀더 준비
class MyViewHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

//항목 구성자, 어댑터
class MyAdapter(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    
    //항목 개수를 판단하기 위해 자동 호출
    override fun getItemCount(): Int = datas.size

    //뷰홀더를 호출하기 위해 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =MyViewHolder(
        ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    //각 항목을 구성하기 위해 호출
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("financeRyu", "onBindViewHolder : $position")
        val binding=(holder as MyViewHolder).binding
       //뷰에 데이터 출력
       binding.itemData.text= datas[position]
       //뷰에 이벤트 추가
       binding.itemRoot.setOnClickListener{
           Log.d("financeRyu", "item root click : $position")
           //항목을 구성하는 데이터에 새로운 데이터를 추가
           datas.add("new Item ${position + 11}")
           notifyDataSetChanged()
       }
    }
}

class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
    //항목이 배치되기 전에 호출됨 onDraw
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        //뷰 크기 계산
        val width = parent.width
        val height = parent.height
        
        //이미지 크기 계산
        val dr: Drawable? = ResourcesCompat.getDrawable(context.resources, R.drawable.kbo, null)
        val drWidth = dr?.intrinsicWidth
        val drHeight = dr?.intrinsicHeight
        
        // 이미지를 출력할 위치 계산
        val left = width/2 - drWidth?.div(2) as Int
        val top = height/2 - drHeight?.div(2) as Int

        //이미지 출력
        c.drawBitmap(
            BitmapFactory.decodeResource(context.getResources(), R.drawable.kbo),
            left.toFloat(),
            top.toFloat(),
            null
        )

    }
    
    //각 항목들을 꾸미기 위해 호출
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1
        if(index % 3 == 0)
            outRect.set(10, 10, 10, 60)
        else
            outRect.set(10, 10, 10, 0)
        view.setBackgroundColor(Color.parseColor("#28A0FF"))
        ViewCompat.setElevation(view, 20.0f)
        
    }


}

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentOneBinding.inflate(inflater, container, false)
        val datas = mutableListOf<String>()
        for(i in 1..9) {
            datas.add("Item $i")
        }
        
        //리사이클러 뷰에 LayoutManager, Adapter, ItemDecoration적용
        val layoutManager = LinearLayoutManager(activity)

        //그리드 레이아웃으로 배치함
        //val layoutManager = GridLayoutManager(activity, 4)
        //가로로 배치하려 할때.
        //layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager=layoutManager
        val adapter = MyAdapter(datas)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))
        return binding.root
    }

}