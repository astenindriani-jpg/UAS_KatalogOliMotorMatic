package com.example.katalogolimotormatic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnLihatKatalog: Button
    private lateinit var btnTambahOli: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLihatKatalog = findViewById(R.id.btnLihatKatalog)
        btnTambahOli = findViewById(R.id.btnTambahOli)

        btnLihatKatalog.setOnClickListener {
            startActivity(Intent(this, KatalogActivity::class.java))
        }

        btnTambahOli.setOnClickListener {
            startActivity(Intent(this, TambahOliActivity::class.java))
        }
    }
}