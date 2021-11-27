package com.example.cryptoapp.Network

import com.example.cryptoapp.data.Crypto
import com.example.cryptoapp.data.CryptoDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("general")
    suspend fun getCrypto() : Response<List<Crypto>>

    @GET("details/{id}")
    fun getDetail(@Path("id") id : String) : Call<CryptoDetail>
}