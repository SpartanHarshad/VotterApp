package com.harshad.voterapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.harshad.voterapp.R
import com.harshad.voterapp.databinding.ActivityVoteBinding

class VoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_vote)

    }
}