package org.geeksforgeeks.verticalseekbar

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.text_view_1)
        val mSeekBar = findViewById<SeekBar>(R.id.seek_bar_1)

        var mMin = 0
        var mMax = 100
        var mCurrent = 20

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mSeekBar.min = mMin
            mSeekBar.max = mMax
        }

        mSeekBar.progress = mCurrent
        mTextView.text = mCurrent.toString()

        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                mCurrent = p1
                mTextView.text = mCurrent.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }
}