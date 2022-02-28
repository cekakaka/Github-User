package com.dwicandra.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    lateinit var iv_logoSplashScreen: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        iv_logoSplashScreen = findViewById(R.id.logo_splash_screen)

        iv_logoSplashScreen.alpha = 0f
        iv_logoSplashScreen.animate().setDuration(1000).alpha(1f).withEndAction {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

    }
}