package com.harshad.voterapp.localdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VoterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerUser(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveVote(voterBoardEntity: VoterBoardEntity)

    @Query("SELECT * FROM voter_board WHERE u_email = :email")
    fun checkUserAlreadyVoted(email: String): LiveData<Int>

    @Query("SELECT SUM (can_1) FROM voter_board")
    fun getVoteCountFirstCandidate(): LiveData<Double>

    @Query("SELECT SUM (can_2) FROM voter_board")
    fun getVoteCountSecondCandidate(): LiveData<Double>

    @Query("SELECT SUM (can_3) FROM voter_board")
    fun getVoteCountThirdCandidate(): LiveData<Double>

    @Query("SELECT SUM (can_4) FROM voter_board")
    fun getVoteCountFourthCandidate(): LiveData<Double>


}