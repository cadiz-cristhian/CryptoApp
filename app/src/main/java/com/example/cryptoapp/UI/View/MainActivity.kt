package com.example.cryptoapp.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.UI.Adapters.CryptoAdapter
import com.example.cryptoapp.UI.ViewModel.CryptoViewModel
import com.example.cryptoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val cryptoViewModel : CryptoViewModel by viewModels()
    lateinit var adapter : CryptoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initViewModel()
    }
    private fun initRecyclerView()
    {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CryptoAdapter(this)
        binding.recyclerView.adapter = adapter
    }
    private fun initViewModel()
    {
        val viewModel : CryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)

        viewModel.cryptoModel.observe(this, Observer {
            if(it != null)
            {
                adapter.loadCrypto(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error al cargar la lista", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.onCreate()


    }
}