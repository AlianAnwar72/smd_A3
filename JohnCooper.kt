package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class JohnCooper : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_john_cooper)
    }
    fun toProfile(view: View) {
        val intent = Intent(this,profile::class.java)
        view.context.startActivity(intent)
        finish()

    }
    fun toBookSessions(view: View) {
        val intent = Intent(this,BookAppointment::class.java)
        view.context.startActivity(intent)
        finish()

    }

    fun toDropReview(view: View) {
        val intent = Intent(this,ReviewJohncooper::class.java)
        view.context.startActivity(intent)
        finish()

    }
}