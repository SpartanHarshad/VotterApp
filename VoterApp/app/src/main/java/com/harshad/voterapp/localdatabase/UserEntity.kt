package com.harshad.voterapp.localdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_details")
data class UserEntity(
    @ColumnInfo(name = "user_name")
    var userName: String,
    @ColumnInfo(name = "pwd")
    var pwd: String,
    @ColumnInfo(name = "email_id")
    var emailId: String,
    @ColumnInfo(name = "phone_no")
    var phoneNo: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uId")
    var uId: Int? = null
}
