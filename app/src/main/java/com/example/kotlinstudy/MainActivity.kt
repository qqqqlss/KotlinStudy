package com.example.kotlinstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                //todo
            }
        })

        //람다로 짧게 줄인 메서드(위와 동일) - 아래 조건 두개를 만족하면 생략 가능
        //1. object가 Kotlin interface가 아닌 자바 인터페이스여야 합니다.
        //2. 그 인터페이스는 딱 하나의 메소드만 가져야 합니다.
        button.setOnClickListener(){
            //todo
        }
    }
}