package com.example.katalogolimotormatic

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
            try {
                Log.d("42430010", "Button Lihat Katalog ditekan")
                val intent = Intent(this, KatalogActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("42430010", "Error buka katalog: ${e.message}")
            }
        }

        btnTambahOli.setOnClickListener {
            try {
                Log.d("42430010", "Button Tambah Oli ditekan")
                val intent = Intent(this, TambahOliActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("42430010", "Error buka tambah oli: ${e.message}")
            }
        }
    }
}