package com.example.cryptoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "currency")
data class Crypto(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : String,
    @ColumnInfo(name = "currency") val currency: String,
    @ColumnInfo(name = "symbo")val symbol : String,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "logo_url") val logo_url : String,
    @ColumnInfo(name = "status") val status : String,
    @ColumnInfo(name = "price") val price : String,
    @ColumnInfo(name = "price_date") val price_date : String,
    @ColumnInfo(name = "price_timestamp") val price_timestamp : String,
    @ColumnInfo(name = "rank")val rank : String)
{

}
