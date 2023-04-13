package com.harshad.voterapp.repository

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import com.harshad.voterapp.localdatabase.UserEntity
import com.harshad.voterapp.localdatabase.VoterBoardEntity
import com.harshad.voterapp.localdatabase.VoterDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VoterRepository(val voterDao: VoterDao) {

    fun regiUser(userEntity: UserEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            voterDao.registerUser(userEntity)
        }
    }

    fun saveVote(voterBoardEntity: VoterBoardEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            voterDao.saveVote(voterBoardEntity)
        }
    }

    fun checkUserAlreadyVoted(email: String): LiveData<Int> {
        return voterDao.checkUserAlreadyVoted(email)
    }

    fun getVoteCountFirstCandidate(): LiveData<Double> {
        return voterDao.getVoteCountFirstCandidate()
    }

    fun getVoteCountSecondCandidate(): LiveData<Double> {
        return voterDao.getVoteCountSecondCandidate()
    }

    fun getVoteCountThirdCandidate(): LiveData<Double> {
        return voterDao.getVoteCountThirdCandidate()
    }

    fun getVoteCountFourthCandidate(): LiveData<Double> {
        return voterDao.getVoteCountFourthCandidate()
    }

}