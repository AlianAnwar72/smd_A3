package com.alian.i210730

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivityx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activityx)
        Handler().postDelayed({
            val intent = Intent(this@SplashActivityx, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
