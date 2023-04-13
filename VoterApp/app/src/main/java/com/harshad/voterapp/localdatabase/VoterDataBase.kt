package com.harshad.voterapp.localdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class, VoterBoardEntity::class], version = 1)
abstract class VoterDataBase : RoomDatabase() {
    abstract fun getVoterDao(): VoterDataBase

    companion object {
        private var INSTANCE: VoterDataBase? = null

        fun getDatabaseInstance(context: Context): VoterDataBase {
            return if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    VoterDataBase::class.java,
                    "voterDatabase"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                INSTANCE!!
            } else {
                INSTANCE!!
            }
        }
    }
}