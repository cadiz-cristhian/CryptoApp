package com.example.cryptoapp.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.Network.CryptoRepository
import com.example.cryptoapp.data.Crypto
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    var cryptoModel : MutableLiveData<List<Crypto>>
    var repo = CryptoRepository()
    init{ cryptoModel = MutableLiveData() }
    fun onCreate()
    {
        viewModelScope.launch {
            val result = repo.getAllInfo()
            if(!result.isNullOrEmpty()){
                cryptoModel.postValue(result)
            }
        }
    }
}