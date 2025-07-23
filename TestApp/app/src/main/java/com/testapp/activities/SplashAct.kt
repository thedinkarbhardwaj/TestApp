package com.testapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.testapp.MainActivity
import com.testapp.R
import com.testapp.Utils.PrefService
import com.testapp.activities.Login.LoginAct
import com.testapp.databinding.ActivitySplashBinding

class SplashAct : AppCompatActivity() {

    lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)



        checkLogin()


    }

    private fun checkLogin() {

        var loggedIn = PrefService.getLoggedIn()

        if (loggedIn){

            Handler(Looper.getMainLooper()).postDelayed({
                Toast.makeText(this@SplashAct,"Main",Toast.LENGTH_LONG).show()
                var intent = Intent(this@SplashAct,MainActivity::class.java)
                startActivity(intent)
            },2000)

        }
        else{


            Handler(Looper.getMainLooper()).postDelayed({
                Toast.makeText(this@SplashAct,"Login",Toast.LENGTH_LONG).show()

                var intent = Intent(this@SplashAct,LoginAct::class.java)
                startActivity(intent)
            },2000)
        }

    }
}