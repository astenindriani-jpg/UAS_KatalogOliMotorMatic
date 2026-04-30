package com.example.katalogolimotormatic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.katalogolimotormatic.model.Oli

class KatalogActivity : AppCompatActivity() {

    private lateinit var btnDetailOli: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katalog)

        btnDetailOli = findViewById(R.id.btnDetailOli)

        val dataOli = DataOli.listOli

        for (oli in dataOli) {
            Log.d("DATA_OLI", "${oli.merk} - ${oli.namaProduk}")
        }

        val hasilCari = linearSearchByMerk(dataOli, "Yamalube")

        btnDetailOli.setOnClickListener {
            if (hasilCari != null) {
                val intent = Intent(this, DetailOliActivity::class.java)
                intent.putExtra("merk", hasilCari.merk)
                intent.putExtra("nama", hasilCari.namaProduk)
                intent.putExtra("jenis", hasilCari.jenis)
                intent.putExtra("harga", hasilCari.harga.toString())
                intent.putExtra("stok", hasilCari.stok.toString())
                intent.putExtra("deskripsi", hasilCari.deskripsi)
                startActivity(intent)
            }
        }
    }

    private fun linearSearchByMerk(data: ArrayList<Oli>, keyword: String): Oli? {
        for (oli in data) {
            if (oli.merk.equals(keyword, ignoreCase = true)) {
                return oli
            }
        }
        return null
    }
}