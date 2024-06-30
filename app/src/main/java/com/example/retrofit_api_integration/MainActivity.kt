package com.example.retrofit_api_integration

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.retrofit_api_integration.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.next.setOnClickListener {
            getdata()
        }
        getdata()

    }
    private fun getdata(){
        val progrss = ProgressDialog(this)
        progrss.setMessage("Loading")
        progrss.show()
        retrofit.apiservice.getdata().enqueue(object : Callback<data_class?> {
            override fun onResponse(call: Call<data_class?>, response: Response<data_class?>) {
                binding.author.text = response.body()?.author
                binding.tittle.text = response.body()?.title
                Glide.with(this@MainActivity).load(response.body()?.url).into(binding.image)
                progrss.dismiss()

            }

            override fun onFailure(call: Call<data_class?>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "errror",
                    Toast.LENGTH_SHORT
                ).show()
                progrss.dismiss()
            }

        })
    }

}