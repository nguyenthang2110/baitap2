package com.example.bai2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btnradio1:RadioButton
    lateinit var btnradio2:RadioButton
    lateinit var btnradio3:RadioButton
    lateinit var btn:Button
    lateinit var textView: TextView
    lateinit var ed:EditText
    lateinit var lv: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnradio1 = findViewById(R.id.radiobtn1)
        btnradio2 = findViewById(R.id.radiobtn2)
        btnradio3 = findViewById(R.id.radiobtn3)
        btn = findViewById(R.id.btnShow)
        textView = findViewById(R.id.textView)
        ed = findViewById(R.id.editText)
        lv = findViewById(R.id.lv)

        btn.setOnClickListener {
            findNumber()
        }
    }
    private fun findNumber(){
        val number=ed.text.toString().toIntOrNull() ?: return
        val arr=ArrayList<Int>()
        if(btnradio1.isChecked){
            for(i in 0..number){
                if(i%2==0)
                    arr.add(i)
            }
        }
        else if(btnradio2.isChecked) {
            for (i in 0..number) {
                if (i % 2 != 0)
                    arr.add(i)
            }
        }
        else if(btnradio3.isChecked){
                for(i in 1 .. number){
                    val sqrt=Math.sqrt(i.toDouble()).toInt()
                    if(sqrt * sqrt == i)
                        arr.add(i)
                }
            }
        else{
            textView.text="Please select an option"
            return
        }
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)
    }

}