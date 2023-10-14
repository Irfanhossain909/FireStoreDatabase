package com.example.firestoredatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firestoredatabase.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity() : AppCompatActivity(), DataAdapter.ItemClickListener{
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val db = FirebaseFirestore.getInstance()
    private val dataCollection = db.collection("data")
    private val data = mutableListOf<Data>()
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = DataAdapter(data, this)
        binding.recicalerview.adapter = adapter
        binding.recicalerview.layoutManager = LinearLayoutManager(this)

        binding.addBtn.setOnClickListener {
            val title = binding.titleEtxt.text.toString()
            val destination = binding.dscEtxt.text.toString()

            if (title.isNotEmpty() && destination.isNotEmpty()){
                addData(title,destination)
            }
        }
        fetchData()

    }

    private fun fetchData() {
        TODO("Not yet implemented")
    }

    private fun addData(title: String, destination: String) {
        val newData = Data(title = title, descreption = destination)
    }

    override fun onEditItemClick(data: Data) {
        TODO("Not yet implemented")
    }

    override fun onDeleteItemClick(data: Data) {
        TODO("Not yet implemented")
    }

}