package com.harshad.voterapp.localdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "voter_board")
data class VoterBoardEntity(
    @ColumnInfo(name = "can_1")
    var can1: String,
    @ColumnInfo(name = "can_2")
    var can2: String,
    @ColumnInfo(name = "can_3")
    var can3: String,
    @ColumnInfo(name = "can_4")
    var can4: String,
    @ColumnInfo(name = "u_email")
    var uEmail: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "vId")
    var vId: Int? = null
}
