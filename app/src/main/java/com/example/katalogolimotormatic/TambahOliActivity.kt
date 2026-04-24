package com.example.katalogolimotormatic

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class TambahOliActivity : AppCompatActivity() {

    private lateinit var etMerk: EditText
    private lateinit var etNamaProduk: EditText
    private lateinit var etJenis: EditText
    private lateinit var etHarga: EditText
    private lateinit var etStok: EditText
    private lateinit var etDeskripsi: EditText
    private lateinit var btnSimpan: AppCompatButton
    private lateinit var btnReset: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_oli)

        initView()
        setButtonActions()
    }

    private fun initView() {
        etMerk = findViewById(R.id.etMerk)
        etNamaProduk = findViewById(R.id.etNamaProduk)
        etJenis = findViewById(R.id.etJenis)
        etHarga = findViewById(R.id.etHarga)
        etStok = findViewById(R.id.etStok)
        etDeskripsi = findViewById(R.id.etDeskripsi)
        btnSimpan = findViewById(R.id.btnSimpan)
        btnReset = findViewById(R.id.btnReset)
    }

    private fun setButtonActions() {
        btnSimpan.setOnClickListener {
            if (validasiInput()) {
                Toast.makeText(this, "Data oli berhasil disimpan", Toast.LENGTH_SHORT).show()
            }
        }

        btnReset.setOnClickListener {
            resetForm()
        }
    }

    private fun validasiInput(): Boolean {
        val merk = etMerk.text.toString().trim()
        val namaProduk = etNamaProduk.text.toString().trim()
        val jenis = etJenis.text.toString().trim()
        val harga = etHarga.text.toString().trim()
        val stok = etStok.text.toString().trim()
        val deskripsi = etDeskripsi.text.toString().trim()

        if (merk.isEmpty()) {
            etMerk.error = "Merk wajib diisi"
            etMerk.requestFocus()
            return false
        }

        if (namaProduk.isEmpty()) {
            etNamaProduk.error = "Nama produk wajib diisi"
            etNamaProduk.requestFocus()
            return false
        }

        if (jenis.isEmpty()) {
            etJenis.error = "Jenis oli wajib diisi"
            etJenis.requestFocus()
            return false
        }

        if (harga.isEmpty()) {
            etHarga.error = "Harga wajib diisi"
            etHarga.requestFocus()
            return false
        }

        if (harga.toIntOrNull() == null) {
            etHarga.error = "Harga harus berupa angka"
            etHarga.requestFocus()
            return false
        }

        if (stok.isEmpty()) {
            etStok.error = "Stok wajib diisi"
            etStok.requestFocus()
            return false
        }

        if (stok.toIntOrNull() == null) {
            etStok.error = "Stok harus berupa angka"
            etStok.requestFocus()
            return false
        }

        if (deskripsi.isEmpty()) {
            etDeskripsi.error = "Deskripsi wajib diisi"
            etDeskripsi.requestFocus()
            return false
        }

        return true
    }

    private fun resetForm() {
        etMerk.text.clear()
        etNamaProduk.text.clear()
        etJenis.text.clear()
        etHarga.text.clear()
        etStok.text.clear()
        etDeskripsi.text.clear()

        etMerk.error = null
        etNamaProduk.error = null
        etJenis.error = null
        etHarga.error = null
        etStok.error = null
        etDeskripsi.error = null

        etMerk.requestFocus()
    }
}