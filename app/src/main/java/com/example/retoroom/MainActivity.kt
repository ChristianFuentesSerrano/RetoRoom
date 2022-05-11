package com.example.retoroom

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retoroom.databinding.ActivityMainBinding

import com.example.retoroom.database.User

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.rvUserEntries.layoutManager = LinearLayoutManager(this)

        binding.btnGuardar.setOnClickListener{
            mainViewModel.saveUser(User(
                0,
                "" + binding.etBuscar.text.toString()
            ))

            mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (!usersList.isNullOrEmpty()) {
                    binding.rvUserEntries.adapter = MainAdapter(usersList)
                } else {
                    Log.d("thesearetheusers", "null or empty")
                }
            }
        }


        mainViewModel.getUsers()
        mainViewModel.savedUsers.observe(this) { usersList ->
            if (!usersList.isNullOrEmpty()) {
                binding.rvUserEntries.adapter = MainAdapter(usersList)
            } else {
                Log.d("thesearetheusers", "null or empty")
            }
        }
    }
}