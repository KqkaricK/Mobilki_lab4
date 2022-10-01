package com.example.myapplication
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pref : SharedPreferences? = null
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)

        var name: String
        var fam: String
        var phone: String
        var but: String
        val regbutton: Button = findViewById<Button>(R.id.reg_but)
        val edph: EditText = findViewById<EditText>(R.id.input1)
        val edname: EditText = findViewById<EditText>(R.id.input2)
        val edfam: EditText = findViewById<EditText>(R.id.input3)

        name = pref.getString("name","")!!
        fam = pref.getString("fam","")!!
        phone = pref.getString("phone","")!!
        but = pref.getString("regbut","Регистрация")!!
        edph.setText(phone)
        edname.setText(name)
        edfam.setText(fam)
        regbutton.text = but

        regbutton.setOnClickListener {
            name = edname.text.toString()
            fam = edfam.text.toString()
            phone = edph.text.toString()
            val editor = pref?.edit()
            editor?.putString("name", name)
            editor?.putString("fam", fam)
            editor?.putString("phone", phone)
            editor?.putString("regbut", "Вход")
            editor?.apply()
            val intent = Intent(this@MainActivity,Activity2::class.java)
            intent.putExtra("name",name)
            intent.putExtra("fam",fam)
            intent.putExtra("phone",phone)
            startActivity(intent)
        }
    }
}





