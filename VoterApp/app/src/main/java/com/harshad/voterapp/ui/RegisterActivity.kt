package com.harshad.voterapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.harshad.voterapp.R
import com.harshad.voterapp.databinding.ActivityRegisterBinding
import com.harshad.voterapp.localdatabase.UserEntity
import com.harshad.voterapp.viewmodel.VoterViewModel
import com.harshad.voterapp.viewmodel.VoterViewModelFactory

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var voterViewModel: VoterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        initViewModel()
        initClicks()
    }

    private fun initViewModel() {
        val voterApp = application as VoterApplication
        val voterRepo = voterApp.voterRepo
        val factory = VoterViewModelFactory(voterRepo)
        voterViewModel = ViewModelProvider(this, factory)[VoterViewModel::class.java]
    }

    private fun initClicks() {
        binding.btnLogIn.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_log_in -> {
                val log = Intent(this, MainActivity::class.java)
                startActivity(log)
            }
            R.id.btn_register -> {
                registerUser()
            }
        }
    }

    private fun registerUser() {
        val email = binding.etvEmailId.text.toString()
        val phoneNo = binding.etvPhoneNo.text.toString()
        val uName = binding.etvUserName.text.toString()
        val pwd = binding.etvPassword.text.toString()
        if (validateInputData()) {
            val userEntity = UserEntity(uName, pwd, email, phoneNo)
            voterViewModel.regiUser(userEntity)
            saveUserAuth(email, pwd)
        }
    }

    private fun saveUserAuth(email: String, pwd: String) {
        auth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                showToast("Register Successfully...")
            } else {
                showToast("something went wrong")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun validateInputData(): Boolean {
        val userName = binding.etvUserName.text.toString()
        val pwd = binding.etvPassword.text.toString()
        val emailId = binding.etvEmailId.text.toString()
        val phoneNo = binding.etvPhoneNo.text.toString()
        return if (userName.isEmpty() || userName.isBlank()) {
            showToast("please enter user name")
            false
        } else if (pwd.isEmpty() || pwd.isBlank()) {
            showToast("please enter password")
            false
        } else if (emailId.isEmpty() || emailId.isBlank()) {
            showToast("please enter email id")
            false
        } else if (phoneNo.isEmpty() || phoneNo.isBlank()) {
            showToast("please enter phone no")
            false
        } else {
            true
        }
    }
}