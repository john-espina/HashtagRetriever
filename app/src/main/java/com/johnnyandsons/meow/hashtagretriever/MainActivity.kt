package com.johnnyandsons.meow.hashtagretriever

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {


    lateinit var layoutController: LayoutController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            layoutController = LayoutController(this, layoutController.layout)
        } else {
            layoutController = LayoutController(this, R.layout.activity_main)
        }
    }
}

