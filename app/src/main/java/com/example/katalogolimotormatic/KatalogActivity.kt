package com.example.katalogolimotormatic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.katalogolimotormatic.model.Oli

class KatalogActivity : AppCompatActivity() {

    private lateinit var btnDetailOli: AppCompatButton
    private lateinit var btnSortNama: AppCompatButton
    private lateinit var btnSortHarga: AppCompatButton
    private lateinit var tvNamaOli: TextView
    private lateinit var tvMerkOli: TextView
    private lateinit var tvHargaOli: TextView

    private var dataOli = arrayListOf<Oli>()
    private var oliAktif: Oli? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katalog)

        btnDetailOli = findViewById(R.id.btnDetailOli)
        btnSortNama = findViewById(R.id.btnSortNama)
        btnSortHarga = findViewById(R.id.btnSortHarga)
        tvNamaOli = findViewById(R.id.tvNamaOli)
        tvMerkOli = findViewById(R.id.tvMerkOli)
        tvHargaOli = findViewById(R.id.tvHargaOli)

        try {
            dataOli = ArrayList(DataOli.listOli)

            if (dataOli.isNotEmpty()) {
                oliAktif = dataOli[0]
                tampilkanData(oliAktif!!)
                Log.d("42430010", "Data oli berhasil dimuat")
            } else {
                Toast.makeText(this, "Data oli kosong", Toast.LENGTH_SHORT).show()
                Log.d("42430010", "Data oli kosong")
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Terjadi kesalahan saat memuat data", Toast.LENGTH_SHORT).show()
            Log.e("42430010", "Error load data: ${e.message}")
        }

        btnSortNama.setOnClickListener {
            try {
                if (dataOli.isNotEmpty()) {
                    bubbleSortNama(dataOli)
                    oliAktif = dataOli[0]
                    tampilkanData(oliAktif!!)
                    Toast.makeText(this, "Data diurutkan berdasarkan nama", Toast.LENGTH_SHORT).show()
                    Log.d("42430010", "Bubble sort nama berhasil")
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Terjadi kesalahan saat sorting nama", Toast.LENGTH_SHORT).show()
                Log.e("42430010", "Error sorting nama: ${e.message}")
            }
        }

        btnSortHarga.setOnClickListener {
            try {
                if (dataOli.isNotEmpty()) {
                    bubbleSortHarga(dataOli)
                    oliAktif = dataOli[0]
                    tampilkanData(oliAktif!!)
                    Toast.makeText(this, "Data diurutkan berdasarkan harga", Toast.LENGTH_SHORT).show()
                    Log.d("42430010", "Bubble sort harga berhasil")
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Terjadi kesalahan saat sorting harga", Toast.LENGTH_SHORT).show()
                Log.e("42430010", "Error sorting harga: ${e.message}")
            }
        }

        btnDetailOli.setOnClickListener {
            try {
                if (oliAktif != null) {
                    val intent = Intent(this, DetailOliActivity::class.java)
                    intent.putExtra("merk", oliAktif!!.merk)
                    intent.putExtra("nama", oliAktif!!.namaProduk)
                    intent.putExtra("jenis", oliAktif!!.jenis)
                    intent.putExtra("harga", oliAktif!!.harga.toString())
                    intent.putExtra("stok", oliAktif!!.stok.toString())
                    intent.putExtra("deskripsi", oliAktif!!.deskripsi)
                    startActivity(intent)
                    Log.d("42430010", "Berhasil membuka detail oli")
                } else {
                    Toast.makeText(this, "Data belum tersedia", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Terjadi kesalahan saat membuka detail", Toast.LENGTH_SHORT).show()
                Log.e("42430010", "Error buka detail: ${e.message}")
            }
        }
    }

    private fun tampilkanData(oli: Oli) {
        tvNamaOli.text = oli.namaProduk
        tvMerkOli.text = "Merk: ${oli.merk}"
        tvHargaOli.text = "Harga: Rp ${oli.harga}"
    }

    private fun bubbleSortNama(data: ArrayList<Oli>) {
        for (i in 0 until data.size - 1) {
            for (j in 0 until data.size - i - 1) {
                if (data[j].namaProduk.lowercase() > data[j + 1].namaProduk.lowercase()) {
                    val temp = data[j]
                    data[j] = data[j + 1]
                    data[j + 1] = temp
                }
            }
        }
    }

    private fun bubbleSortHarga(data: ArrayList<Oli>) {
        for (i in 0 until data.size - 1) {
            for (j in 0 until data.size - i - 1) {
                if (data[j].harga > data[j + 1].harga) {
                    val temp = data[j]
                    data[j] = data[j + 1]
                    data[j + 1] = temp
                }
            }
        }
    }
}