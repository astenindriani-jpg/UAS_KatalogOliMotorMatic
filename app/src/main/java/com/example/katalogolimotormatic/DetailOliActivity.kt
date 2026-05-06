package com.example.katalogolimotormatic

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class DetailOliActivity : AppCompatActivity() {

    private lateinit var tvMerk: TextView
    private lateinit var tvNama: TextView
    private lateinit var tvJenis: TextView
    private lateinit var tvHarga: TextView
    private lateinit var tvStok: TextView
    private lateinit var tvDeskripsi: TextView
    private lateinit var btnKembali: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_oli)

        tvMerk = findViewById(R.id.tvMerk)
        tvNama = findViewById(R.id.tvNama)
        tvJenis = findViewById(R.id.tvJenis)
        tvHarga = findViewById(R.id.tvHarga)
        tvStok = findViewById(R.id.tvStok)
        tvDeskripsi = findViewById(R.id.tvDeskripsi)
        btnKembali = findViewById(R.id.btnKembali)

        try {
            val merk = intent.getStringExtra("merk") ?: "-"
            val nama = intent.getStringExtra("nama") ?: "-"
            val jenis = intent.getStringExtra("jenis") ?: "-"
            val harga = intent.getStringExtra("harga") ?: "-"
            val stok = intent.getStringExtra("stok") ?: "-"
            val deskripsi = intent.getStringExtra("deskripsi") ?: "-"

            tvMerk.text = "Merk: $merk"
            tvNama.text = "Nama Produk: $nama"
            tvJenis.text = "Jenis: $jenis"
            tvHarga.text = "Harga: Rp $harga"
            tvStok.text = "Stok: $stok"
            tvDeskripsi.text = "Deskripsi: $deskripsi"

            Log.d("42430010", "Halaman detail oli dibuka")
        } catch (e: Exception) {
            Log.e("42430010", "Error menampilkan detail: ${e.message}")
        }

        btnKembali.setOnClickListener {
            finish()
        }
    }
}