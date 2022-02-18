package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.CompoundButton
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener(object:CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.d("kkang", "체크박스 클릭")
            }

        })

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("kkang", "Touch down event x : ${event.x}, rawX : ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("kkang", "Touch up event")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        when(keyCode) {
            KeyEvent.KEYCODE_BACK -> Log.d("KKANG","BACK Button을 눌렀내요")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("KKANG","Volume Up 키를 눌렀내요")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("KKANG","Volume Down 키를 눌렀내요")
        }

        return super.onKeyDown(keyCode, event)
    }



}