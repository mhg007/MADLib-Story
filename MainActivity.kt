package com.example.lab05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun getStarted(view: View){
        var intent : Intent = Intent(this,ActivityWords::class.java)
        startActivity(intent)
    }
}