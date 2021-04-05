package com.openld.androidpokkit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.openld.androidpokkit.chapter1.activity.TestActivity
import com.openld.androidpokkit.chapter6.handler.HandlerActivity

class MainActivity : AppCompatActivity() {
    // 第一章节 Android四大组件相关
    private lateinit var mBtnChapter1: Button

    private lateinit var mBtnChapter2: Button

    private lateinit var mBtnChapter3: Button

    private lateinit var mBtnChapter4: Button

    private lateinit var mBtnChapter5: Button

    private lateinit var mBtnChapter6: Button

    private lateinit var mBtnChapter7: Button

    private lateinit var mBtnChapter8: Button

    private lateinit var mBtnChapter9: Button

    private lateinit var mBtnChapter10: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWidgets();
    }

    /**
     * 初始化组件
     */
    private fun initWidgets() {
        mBtnChapter1 = findViewById(R.id.btn_chapter1)
        mBtnChapter2 = findViewById(R.id.btn_chapter2)
        mBtnChapter3 = findViewById(R.id.btn_chapter3)
        mBtnChapter4 = findViewById(R.id.btn_chapter4)
        mBtnChapter5 = findViewById(R.id.btn_chapter5)
        mBtnChapter6 = findViewById(R.id.btn_chapter6)
        mBtnChapter7 = findViewById(R.id.btn_chapter7)
        mBtnChapter8 = findViewById(R.id.btn_chapter8)
        mBtnChapter9 = findViewById(R.id.btn_chapter9)
        mBtnChapter10 = findViewById(R.id.btn_chapter10)
    }

    /**
     * 点击了Chapter1
     */
    fun onClickChapter1(view: View) {
        val intent = Intent(this, TestActivity::class.java)
        startActivity(intent)
    }

    /**
     * 点击了了Chapter2
     */
    fun onClickChapter2(view: View) {
        // TODO: 2021/3/28  
    }

    /**
     * 点击了了Chapter3
     */
    fun onClickChapter3(view: View) {
        // TODO: 2021/3/28  
    }

    /**
     * 点击了了Chapter4
     */
    fun onClickChapter4(view: View) {
        // TODO: 2021/3/28  
    }

    /**
     * 点击了了Chapter5
     */
    fun onClickChapter5(view: View) {
        // TODO: 2021/3/28  
    }

    /**
     * 点击了了Chapter6
     */
    fun onClickChapter6(view: View) {
        // TODO: 2021/3/28
        val intent = Intent(this, HandlerActivity::class.java)
        startActivity(intent)
    }

    /**
     * 点击了了Chapter7
     */
    fun onClickChapter7(view: View) {
        // TODO: 2021/3/28  
    }

    /**
     * 点击了了Chapter8
     */
    fun onClickChapter8(view: View) {
        // TODO: 2021/3/28  
    }

    /**
     * 点击了了Chapter9
     */
    fun onClickChapter9(view: View) {
        // TODO: 2021/3/28  
    }

    /**
     * 点击了了Chapter10
     */
    fun onClickChapter10(view: View) {
        // TODO: 2021/3/28
    }
}