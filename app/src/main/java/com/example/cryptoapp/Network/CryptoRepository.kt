package com.example.cryptoapp.Network

import com.example.cryptoapp.data.Crypto
import com.example.cryptoapp.data.CryptoProvider

class CryptoRepository {
    private val api = CryptoService()
    private var list = CryptoProvider.cryptoList

    suspend fun getAllInfo(): List<Crypto> {
        val response = api.getCrypto()
        list = response
        return response
    }
}
