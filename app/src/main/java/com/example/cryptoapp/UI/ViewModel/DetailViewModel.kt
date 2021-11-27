package com.example.cryptoapp.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.Network.ApiClient
import com.example.cryptoapp.Network.ApiCrypto
import com.example.cryptoapp.data.CryptoDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val retrofit = ApiCrypto.getRetrofit()
    private val service : ApiClient = retrofit.create(ApiClient::class.java)
    val cryptoDetail = MutableLiveData<CryptoDetail>()

    fun getDetalle(id : String){
        val call = service.getDetail(id)
        call.enqueue(object : Callback<CryptoDetail> {
            override fun onResponse(
                call: Call<CryptoDetail>,
                response: Response<CryptoDetail>
            ){
                response.body()?.let {
                        detalle -> cryptoDetail.postValue(detalle) }}

            override fun onFailure(p0: Call<CryptoDetail>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        }
        )
    }
}