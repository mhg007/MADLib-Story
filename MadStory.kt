package com.example.lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MadStory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mad_story)

        var story  = intent.extras?.get("story")
        findViewById<TextView>(R.id.txtStory).text = story.toString()
    }
}