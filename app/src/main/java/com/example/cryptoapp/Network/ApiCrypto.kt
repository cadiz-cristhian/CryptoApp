package com.example.cryptoapp.Network

import retrofit2.Retrofit

object ApiCrypto {
    fun getRetrofit(): retrofit2.Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fake-server-app-crypto.herokuapp.com/")
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
    }
}