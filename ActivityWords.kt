package com.example.lab05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class ActivityWords : AppCompatActivity() {
    private var i = 0
    private var listOfWords : ArrayList<String> = ArrayList()
    var myStory = ""
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        var scan = Scanner(resources.openRawResource(R.raw.madlib1))
        while (scan.hasNext()){
            var word = scan.next()
            if(word.startsWith("<") && word.endsWith(">"))
            {
                listOfWords.add(word.substring(1,word.length-1))
            }
            myStory += word
        }
        i = listOfWords.size
        findViewById<TextView>(R.id.txtWordsCount).text = "$i word(s) left"
    }
    fun createStory(view:View){
        var intent : Intent = Intent(this,MadStory::class.java)
        intent.putExtra("story",myStory)
        startActivity(intent)
    }
    fun story(view: View){
        if(i==1){
            Toast.makeText(this, "Now, Create story", Toast.LENGTH_SHORT).show()
        }
        else{
            var txt : EditText = findViewById(R.id.tbNouns)
            myStory = myStory.replace("<${listOfWords.get(index++)}>",txt.text.toString())
            i--
            findViewById<TextView>(R.id.txtWordsCount).text = "$i word(s) left"
            Toast.makeText(this, "Word added", Toast.LENGTH_SHORT).show()
            txt.setText("")
        }
    }
}
