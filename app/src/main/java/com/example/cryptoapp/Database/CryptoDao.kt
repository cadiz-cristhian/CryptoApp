package com.example.cryptoapp.Database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.Crypto

interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCrypto (crypto :List<Crypto>?)

    @Query("SELECT * FROM currency ORDER BY id DESC")
    fun allCrypto() : List<Crypto>?


}