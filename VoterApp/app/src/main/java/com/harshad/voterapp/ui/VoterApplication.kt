package com.harshad.voterapp.ui

import android.app.Application
import com.harshad.voterapp.localdatabase.VoterDataBase
import com.harshad.voterapp.repository.VoterRepository

class VoterApplication : Application() {
    val voterDao by lazy {
        val roomDatabase = VoterDataBase.getDatabaseInstance(this)
        roomDatabase.getVoterDao()
    }

    val voterRepo by lazy {
        VoterRepository(voterDao)
    }

}