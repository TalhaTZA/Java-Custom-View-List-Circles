package com.example.customviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var page = 1

        circle_selector.apply {
            setCount(5)
        }

        click.apply {
            setOnClickListener{
                circle_selector.setCurrentPage(page++)
                if(page==5) page=0
            }
        }
    }
}
