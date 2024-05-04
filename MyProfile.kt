package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
    }

    fun toSearch(view: View) {
         val intent = Intent(this,LetsFindActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }

    fun toProfile(view: View) {
        val intent = Intent(this,profile::class.java)
        view.context.startActivity(intent)
        finish()
    }
    fun toEditProfile(view: View) {
        val intent = Intent(this,EditProfile::class.java)
        view.context.startActivity(intent)
        finish()
    }

    fun toBookSessions(view: View) {
        val intent = Intent(this,BookedSessions::class.java)
        view.context.startActivity(intent)
        finish()
    }


    fun toAdd(view: View) {
        val intent = Intent(this,AddMentorActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }

    fun toChat(view: View) {
        val intent = Intent(this,chats::class.java)
        view.context.startActivity(intent)
        finish()
    }

    fun toJohn(view: View) {
        val intent = Intent(this,JohnCooper::class.java)
        view.context.startActivity(intent)
        finish()
    }
}