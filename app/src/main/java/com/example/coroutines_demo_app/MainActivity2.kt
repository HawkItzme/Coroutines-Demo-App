package com.example.coroutines_demo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        CoroutineScope(Dispatchers.IO).launch {
            Log.v("TAGY", "The App started")

            val one = doSomeThingUseful1()
            val two = doSomeThingUseful2()

            val result = one + two
            Log.v("TAGY", "The Result is: $result")

        }

    }

    suspend fun doSomeThingUseful1() : Int{
        delay(9000)
        Log.v("TAGY", "Fun1 is DONE")
        return 11
    }

    suspend fun doSomeThingUseful2() : Int{
        delay(7000)
        Log.v("TAGY", "Fun2 is DONE")
        return 8
    }


}