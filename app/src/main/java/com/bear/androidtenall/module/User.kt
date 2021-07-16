package com.bear.androidtenall.module

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName="users")
data class User(@PrimaryKey @ColumnInfo(name = "userId") var id:Int, @SerializedName("login") val userName:String,@SerializedName("node_id") val address:String)
