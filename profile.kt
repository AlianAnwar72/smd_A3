package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun toSearch(view: View) {
        val intent = Intent(this,LetsFindActivity::class.java)
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

    fun toMyProfile(view: View) {
        val intent = Intent(this,MyProfile::class.java)
        view.context.startActivity(intent)
        finish()
    }

    fun toNotification(view: View) {
        val intent = Intent(this,NotificationActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }


}