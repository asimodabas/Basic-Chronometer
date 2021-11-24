package com.asimodabas.timer_chronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.asimodabas.timer_chronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var number = 0
    var runnable: Runnable = Runnable { }
    var handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            start()
        }
        binding.button2.setOnClickListener {

            stop()
        }
    }

    fun start() {

        number = 0
        runnable = object : Runnable {
            override fun run() {
                number = number + 1
                binding.textView.text = "Time: $number"
                handler.postDelayed(this, 1000)
            }

        }
        handler.post(runnable)

    }

    fun stop() {

        handler.removeCallbacks(runnable)
        number = 0
        binding.textView.text = "Time: 0"
    }


}