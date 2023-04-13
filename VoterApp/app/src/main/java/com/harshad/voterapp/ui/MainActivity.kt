package com.harshad.voterapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.harshad.voterapp.R
import com.harshad.voterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    companion object {
        var uEmailId = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initClicks()
    }

    private fun initClicks() {
        binding.btnLogIn.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_log_in -> {
                logInUser()
            }
            R.id.btn_register -> {
                val reg = Intent(this, RegisterActivity::class.java)
                startActivity(reg)
            }
        }
    }

    private fun logInUser() {
        val email = binding.etvEmail.text.toString()
        val pwd = binding.etvPassword.text.toString()
        uEmailId = email
        if (email.isNotEmpty() && pwd.isNotEmpty()) {
            logInGotoVoteScreen(email, pwd)
        } else if (pwd.isEmpty() || pwd.isBlank()) {
            showToast("Please enter password")
        } else {
            showToast("Please enter email")
        }
    }

    private fun logInGotoVoteScreen(email: String, pwd: String) {
        auth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val voterScreen = Intent(this, VoteActivity::class.java)
                startActivity(voterScreen)
            }else{
                showToast("Some thing went wrong")
            }
        }
    }

    private fun showToast(Message: String) {
        Toast.makeText(baseContext, Message, Toast.LENGTH_SHORT).show()
    }
}