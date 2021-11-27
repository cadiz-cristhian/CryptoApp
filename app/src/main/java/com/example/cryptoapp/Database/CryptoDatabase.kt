package com.example.cryptoapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapp.data.Crypto

@Database(entities = [Crypto::class], version = 1,exportSchema = false)
abstract class CryptoDatabase : RoomDatabase(){

    abstract fun cryptoDao() : CryptoDao?
    companion object{
        private var INSTANCE: CryptoDatabase? = null
        fun getDataBase(context: Context): CryptoDatabase?{

            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<CryptoDatabase>(
                    context.applicationContext,CryptoDatabase::class.java,"CryptoDB"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}