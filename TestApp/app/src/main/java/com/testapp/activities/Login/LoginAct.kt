package com.testapp.activities.Login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.testapp.MainActivity
import com.testapp.R
import com.testapp.Utils.PrefService
import com.testapp.databinding.ActivityLoginBinding
import com.testapp.databinding.ActivitySplashBinding

class LoginAct : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel:LoginVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this@LoginAct).get(LoginVM::class.java)
        viewModel.init(this@LoginAct)

        setUI()


    }

    private fun setUI() {

        binding.btnLogin.setOnClickListener(this)

        viewModel.liveLoginData.observe(this,{
            if (it.status == "1"){
                Handler(Looper.myLooper()!!).postDelayed({

                    PrefService.setLoggedIn(true)

                    var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                },1000)
            }
        })
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.btnLogin ->{

                viewModel.apiLogin()
            }
        }
    }
}