package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
    }


    fun toLogin(view: View) {
        val intent = Intent(this,LoginActivity::class.java)
        view.context.startActivity(intent)
        finish()

    }
}