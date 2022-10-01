package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class Activity3: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)

        findViewById<Button>(R.id.button2).setOnClickListener {
            val fromStreet: String = findViewById<EditText>(R.id.from_st).text.toString()
            val fromDom: String = findViewById<EditText>(R.id.from_d).text.toString()
            val toStreet: String = findViewById<EditText>(R.id.to_st).text.toString()
            val toDom: String = findViewById<EditText>(R.id.to_d).text.toString()
            val intent = Intent()
            intent.putExtra("result", "Откуда: $fromStreet, $fromDom\nКуда: $toStreet, $toDom")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}