package com.harshad.voterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harshad.voterapp.repository.VoterRepository

class VoterViewModelFactory(private val voterRepository: VoterRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VoterViewModel(voterRepository) as T
    }
}