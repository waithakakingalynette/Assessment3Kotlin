package com.example.assessment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assessment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            clearErrors()
            validateRegistration()
        }
    }

    fun validateRegistration() {
        val username = binding.etusername.text.toString()
        val email = binding.etemailAddress.text.toString()
        val phonenumber=binding.etphoneNumber.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmpassword = binding.etconfirmPassword.text.toString()
        var error = false

        if (username.isBlank()) {
            binding.tilusername.error = "Your username is required for registration"
            error = true
        }

        if (email.isBlank()) {
            binding.tilemailAddress.error = "Your email is required"
            error = true
        }

        if (phonenumber.isBlank()){
            binding.tilphoneNumber.error="Your phone number required"
            error =true
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "Your password is required"
            error = true
        }

        if (password != confirmpassword) {
            binding.tilconfirmPasword.error = "The password does not match"
            error = true
        }
        if (!error) {
            Toast.makeText(
                this,
                " Hello $username you have successfully registered your account",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun clearErrors() {
        binding.tilusername.error = null
        binding.tilemailAddress.error = null
        binding.tilphoneNumber.error=null
        binding.tilPassword.error = null
        binding.tilconfirmPasword.error = null
    }
}

