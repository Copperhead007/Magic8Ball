package com.bignerdranch.android.magic8ball

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "ViewModel"
class EightViewModel : ViewModel() {
    var currentIndex = 0
    private val responseBank = listOf(
        Response(R.string.response_a),
        Response(R.string.response_b),
        Response(R.string.response_c),
        Response(R.string.response_d),
        Response(R.string.response_e),
        Response(R.string.response_f),
        Response(R.string.response_g),
        Response(R.string.response_h),
        Response(R.string.response_i),
        Response(R.string.response_j),
        Response(R.string.response_k),
        Response(R.string.response_l),
        Response(R.string.response_m),
        Response(R.string.response_n),
        Response(R.string.response_o),
        Response(R.string.response_p),
        Response(R.string.response_q),
        Response(R.string.response_r),
        Response(R.string.response_s),
        Response(R.string.response_t)
    )

    val currentQuestionText: Int
        get() = responseBank[currentIndex].textResId

    fun moveToNext()
    {
        val hold = currentIndex
        currentIndex = randRange()
        //val spot = responseBank[currentIndex].textResId
    }


override fun onCleared() {
    super.onCleared()
    Log.d(TAG, "ViewModel instance about to be destroyed")
}
    private fun randRange(): Int {
        return (0..19).shuffled().first();
    }
}