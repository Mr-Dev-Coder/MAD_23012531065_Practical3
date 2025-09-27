package com.example.mad_23012531065_practical3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mad_23012531065_practical3.databinding.ActivityMainBinding
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }

        findViewById<Button>(R.id.btnCall).setOnClickListener {
            val callIntent=Intent(Intent.ACTION_DIAL).apply {
                val phone=findViewById<EditText>(R.id.phoneNumber).text.toString()
                data= "tel:+91$phone".toUri()
            }
            startActivity(callIntent)
        }

        findViewById<Button>(R.id.btnBrowse).setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW).apply {
                val url=findViewById<EditText>(R.id.webUrlText).text.toString()
                data = "https://$url".toUri()
            }
            startActivity(webIntent)
        }

        findViewById<Button>(R.id.btnGallery).setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_VIEW).apply { type="image/*" }
            startActivity(galleryIntent)
        }

        findViewById<Button>(R.id.btnCamera).setOnClickListener {
            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }

        findViewById<Button>(R.id.btnAlarm).setOnClickListener {
            val alarmIntent = Intent(android.provider.AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(alarmIntent)
        }
    }
    
}