package com.bignerdranch.android.magic8ball

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"
private var clicked = 0
class MainActivity : AppCompatActivity() {
    private lateinit var ask: Button
    private lateinit var responseTextView: TextView
    private val eightViewModel: EightViewModel by lazy { ViewModelProviders.of(this).get(EightViewModel::class.java)}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        ask = findViewById(R.id.ask_a_question)
        responseTextView = findViewById(R.id.response_view)


        ask.setOnClickListener {

            eightViewModel.moveToNext()
            clicked += 1
            updateResponse()

        }

         updateResponse()

        }
    override fun onStart() {
        super.onStart()
        //responseTextView.setText("...")
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() { super.onResume()
        Log.d(TAG, "onResume() called") }
    override fun onPause() { super.onPause()
        Log.d(TAG, "onPause() called") }
    override fun onStop() { super.onStop()
        Log.d(TAG, "onStop() called") }
    override fun onDestroy() { super.onDestroy()
        Log.d(TAG, "onDestroy() called")}

    private fun updateResponse() {
        if (clicked == 0) {
            responseTextView.setText("...")
        } else {
            val responseTextResId = eightViewModel.currentQuestionText
            responseTextView.setText(responseTextResId)

        }
    }
}
//val provider: ViewModelProvider = ViewModelProviders.of(this)
//val quizViewModel = provider.get(EightViewModel::class.java)
//Log.d(TAG, "Got a EightViewModel: $quizViewModel")
//responseTextView.setText(responseBank[currentIndex].textResId)
//val responseTextResId = eightViewModel.currentIndex