package com.example.myapplication
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity2: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        val arguments = intent.extras
        if (arguments != null){
            val name = arguments.getString("name")
            val fam = arguments.getString("fam")
            val phone = arguments.getString("phone")
            findViewById<TextView>(R.id.fio).text = fam
            findViewById<TextView>(R.id.fio2).text = name
            findViewById<TextView>(R.id.phone).text = phone
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivityForResult(intent,1)
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            Toast.makeText(this, "Ожидайте такси", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK){
            findViewById<TextView>(R.id.path).text = data?.getStringExtra("result")
            findViewById<Button>(R.id.button3).isEnabled = true
        }
    }

}