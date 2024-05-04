package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BookAppointment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)
    }

    fun toBookedSessions(view: View) {
        val intent = Intent(this,BookedSessions::class.java)
        view.context.startActivity(intent)
        finish()
    }

    fun toJohn(view: View) {
        val intent = Intent(this,JohnCooper::class.java)
        view.context.startActivity(intent)
        finish()

    }
}