package com.markotron.kaptsampleproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.markotron.annotation.MyAnnotation

@MyAnnotation
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}

@MyAnnotation class Testing