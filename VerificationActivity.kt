package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class VerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
    }

    fun BackToSignup(view: View) {
        val intent = Intent(this,SignupActivity::class.java)
        view.context.startActivity(intent)
        finish()

    }

    fun toProfile(view: View) {
        val intent = Intent(this, profile::class.java)
        view.context.startActivity(intent)
        finish()
    }
}