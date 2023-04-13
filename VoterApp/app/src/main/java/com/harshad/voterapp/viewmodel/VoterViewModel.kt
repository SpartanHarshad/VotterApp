package com.harshad.voterapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.harshad.voterapp.localdatabase.UserEntity
import com.harshad.voterapp.localdatabase.VoterBoardEntity
import com.harshad.voterapp.repository.VoterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VoterViewModel (val voterRepo: VoterRepository):ViewModel() {

    fun regiUser(userEntity: UserEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            voterRepo.regiUser(userEntity)
        }
    }

    fun saveVote(voterBoardEntity: VoterBoardEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            voterRepo.saveVote(voterBoardEntity)
        }
    }

    fun checkUserAlreadyVoted(email: String): LiveData<Int> {
        return voterRepo.checkUserAlreadyVoted(email)
    }

    fun getVoteCountFirstCandidate(): LiveData<Double> {
        return voterRepo.getVoteCountFirstCandidate()
    }

    fun getVoteCountSecondCandidate(): LiveData<Double> {
        return voterRepo.getVoteCountSecondCandidate()
    }

    fun getVoteCountThirdCandidate(): LiveData<Double> {
        return voterRepo.getVoteCountThirdCandidate()
    }

    fun getVoteCountFourthCandidate(): LiveData<Double> {
        return voterRepo.getVoteCountFourthCandidate()
    }

}