package com.openld.androidpokkit.chapter1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.openld.androidpokkit.R

/**
 * 测试Android四大组件之Activity
 */
class TestActivity : AppCompatActivity() {
    private val TAG = "TestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        Log.d(TAG, ">>> onCreate")
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, ">>> onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, ">>> onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, ">>> onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, ">>> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, ">>> onDestroy")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d(TAG, ">>> onRestart")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d(TAG, ">>> onNewIntent")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d(TAG, ">>> onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d(TAG, ">>> onRestoreInstanceState")
    }
}