package com.lordkajoc.latihansharedpreferences2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lordkajoc.latihansharedpreferences2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("dataprefrences", Context.MODE_PRIVATE)

        saveData()
        viewData()
        clearData()

    }

    fun saveData() {
        binding.buttonsave.setOnClickListener {
            val inputNama = binding.etNama.text.toString()
            val inputId = binding.etId.text.toString()

            val save = sharedPreferences.edit()
            save.putString("inputnama", inputNama)
            save.putString("inputid", inputId)
            save.apply()
            Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_LONG).show()
        }
    }

    fun viewData() {
        binding.buttonview.setOnClickListener {
            val tampilnama = sharedPreferences.getString("inputnama", "defaultnama")
            val tampilid = sharedPreferences.getString("inputid", "defaultid")
            binding.textViewNama.text = tampilnama
            binding.textViewId.text = tampilid
            Toast.makeText(this, "Data Ditampilkan", Toast.LENGTH_LONG).show()
        }
    }

    fun clearData() {
        binding.buttonclear.setOnClickListener {
            val clear = sharedPreferences.edit()
            clear.clear()
            clear.apply()
            binding.textViewNama.text = ""
            binding.textViewId.text = ""
            Toast.makeText(this, "Data Dihapus", Toast.LENGTH_LONG).show()
        }
    }
}