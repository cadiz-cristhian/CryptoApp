package com.example.cryptoapp.UI.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.Database.CryptoDatabase
import com.example.cryptoapp.data.Crypto
import kotlinx.coroutines.launch

class DatabaseViewModel(app: Application)  : AndroidViewModel(app){
    lateinit var allCrypto : MutableLiveData<List<Crypto>>
   public val cryptoDao = CryptoDatabase.getDataBase((getApplication()))?.cryptoDao()
    init { allCrypto = MutableLiveData() }

    fun getAllDaoCrypto()
    {
        val list = cryptoDao?.allCrypto()
        allCrypto.postValue(list!!)
    }
    fun insertCrypto(entity : List<Crypto>){
        viewModelScope.launch {
            cryptoDao?.addCrypto(entity)
            getAllDaoCrypto()
            }
    }


}