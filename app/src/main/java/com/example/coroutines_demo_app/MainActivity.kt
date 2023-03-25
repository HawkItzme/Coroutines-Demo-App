package com.example.coroutines_demo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutines_demo_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var counter : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ctnButton.setOnClickListener{
            binding.textView.text = counter++.toString()
        }

        binding.dwnBtn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                downloadFile()
            }
        }
    }

    private suspend fun downloadFile(){
        for(i in 1..1000000){

            //Here, as only the original thread that created a view hierarchy can touch its views.
            //So we are using withcontext() to share the downloaded values in bg thread into the view that is shown only by the main thread.
            withContext(Dispatchers.Main){
                binding.textView3.text = " $i in ${Thread.currentThread().name} "
            }
        }
    }

}