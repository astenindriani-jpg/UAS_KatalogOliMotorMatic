package com.example.katalogolimotormatic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class KatalogActivity : AppCompatActivity() {

    private lateinit var btnDetailOli: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katalog)

        btnDetailOli = findViewById(R.id.btnDetailOli)

        btnDetailOli.setOnClickListener {
            val intent = Intent(this, DetailOliActivity::class.java)
            intent.putExtra("merk", "Yamalube")
            intent.putExtra("nama", "Yamalube Matic 10W-40")
            intent.putExtra("jenis", "Oli Mesin")
            intent.putExtra("harga", "68000")
            intent.putExtra("stok", "12")
            intent.putExtra("deskripsi", "Oli mesin motor matic untuk pemakaian harian.")
            startActivity(intent)
        }
    }
}