package com.touta.courses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.touta.courses.ui.user.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}