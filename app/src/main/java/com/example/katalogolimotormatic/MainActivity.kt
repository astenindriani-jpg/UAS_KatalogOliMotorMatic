package com.example.katalogolimotormatic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnLihatKatalog: AppCompatButton
    private lateinit var btnTambahOli: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLihatKatalog = findViewById(R.id.btnLihatKatalog)
        btnTambahOli = findViewById(R.id.btnTambahOli)

        btnLihatKatalog.setOnClickListener {
            val intent = Intent(this, KatalogActivity::class.java)
            startActivity(intent)
        }

        btnTambahOli.setOnClickListener {
            val intent = Intent(this, TambahOliActivity::class.java)
            startActivity(intent)
        }
    }
}