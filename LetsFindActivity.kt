package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LetsFindActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lets_find)
    }

    fun toMyProfile(view: View) {
        val intent = Intent(this,MyProfile::class.java)
        view.context.startActivity(intent)
        finish()
    }
    fun toSearchResults(view: View) {
        val intent = Intent(this,SearchResultsActivity::class.java)
        view.context.startActivity(intent)
        finish()
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
}