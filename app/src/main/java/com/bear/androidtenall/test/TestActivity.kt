package com.bear.androidtenall.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.bear.androidtenall.R

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val textView=findViewById<EditText>(R.id.textView2)
        val button=findViewById<TextView>(R.id.button2)
        button.isEnabled=false
        textView.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0!=null){
                    button.isEnabled=p0.isNotEmpty()
                }else{
                    button.isEnabled=false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}