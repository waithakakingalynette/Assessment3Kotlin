package com.example.assessment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assessment3.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()
        binding.btnprevious.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            approveLogin()
        }
    }

    fun approveLogin(){
        val username = binding.etuserName.text.toString()
        val email = binding.etEmail.text.toString()
        val phonenumber=binding.etphonenumber.text.toString()
        val password = binding.etpassword.text.toString()
        val confirmation = binding.etconfirmpassword.text.toString()
        var error = false

        if (username.isBlank()) {
            binding.tiluserName.error = "Your username is required"
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = "your email is required"
            error = true
        }

        if (phonenumber.isBlank()){
            binding.tilphonenumber.error="Your phone number required"
            error =true
        }

        if (password.isBlank()) {
            binding.tilpassword.error = "Your password is required"
            error = true
        }

        if (password != confirmation) {
            binding.tilconfirmpassword.error = "Sorry but your password does not match"
            error = true
        }
        if (!error) {
            Toast.makeText(
                this,
                " Hello $username your have successfully logged into your account ",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun clearErrors() {
        binding.tiluserName.error = null
        binding.tilEmail.error = null
        binding.tilphonenumber.error=null
        binding.tilpassword.error = null
        binding.tilconfirmpassword.error = null
    }

    }
