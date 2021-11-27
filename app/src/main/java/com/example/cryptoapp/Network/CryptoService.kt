package com.example.cryptoapp.Network

import com.example.cryptoapp.data.Crypto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoService {
    private val retrofit = ApiCrypto.getRetrofit()
    private val service : ApiClient = retrofit.create(ApiClient::class.java)

    suspend fun getCrypto() : List<Crypto>
    {
        return withContext(Dispatchers.IO)
        {
            val response = service.getCrypto()
            response.body() ?: emptyList()
        }
    }

}