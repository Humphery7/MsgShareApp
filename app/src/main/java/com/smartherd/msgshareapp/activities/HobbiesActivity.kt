package com.smartherd.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.msgshareapp.adapters.HobbiesAdapter
import com.smartherd.msgshareapp.databinding.ActivityHobbiesBinding
import com.smartherd.msgshareapp.models.Supplier

class HobbiesActivity:AppCompatActivity(){

    private lateinit var binding: ActivityHobbiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHobbiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        binding.recyclerView.adapter = adapter
    }
}