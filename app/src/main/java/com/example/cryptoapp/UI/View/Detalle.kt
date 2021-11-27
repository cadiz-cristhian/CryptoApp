package com.example.cryptoapp.UI.View

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cryptoapp.UI.ViewModel.DetailViewModel
import com.example.cryptoapp.databinding.ActivityDetalleBinding

class Detalle : AppCompatActivity() {

    private lateinit var binding : ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        Glide.with(this).load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.bdo.global%2FInsights%2FBlockchain-Forging-the-Future-of-Asset-Management&psig=AOvVaw06r3Yjc7UaqewO_CVRCEsO&ust=1638124533695000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMj44MyXufQCFQAAAAAdAAAAABAD").into(binding.ivlogo)


    }
    private fun initViewModel()
    {
        val viewModel : DetailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val id = intent.extras?.get("id") as String
        viewModel.getDetalle(id)
        viewModel.cryptoDetail.observe(this, Observer { cryptoDetail ->
            binding.txtDetailName.text = cryptoDetail.name
            binding.txtDetailSymbol2.text = cryptoDetail.symbol
            binding.txtdetailStatus2.text = cryptoDetail.status
            binding.txtDetailPrice2.text = cryptoDetail.price
            binding.txtDetailPriceD2.text = cryptoDetail.price_date
            binding.txtDetailPriceTs2.text = cryptoDetail.price_timestamp
            binding.txtDetailCirculating2.text = cryptoDetail.circulating_supply
            binding.txtDetailMarketCap2.text = cryptoDetail.market_cap
            binding.txtDetailNumExchanges2.text = cryptoDetail.num_exchanges
            binding.txtDetailNumPairs2.text = cryptoDetail.num_pairs
            binding.txtDetailNumPairsUnmapped2.text = cryptoDetail.num_pairs_unmapped
            binding.txtDetailFirstC2.text = cryptoDetail.first_candle
            binding.txtDetailFirstT2.text = cryptoDetail.first_trade
            binding.txtDetailFirstOB2.text = cryptoDetail.first_order_book
            binding.txtDetailRank2.text = cryptoDetail.rank
            binding.txtDetailRankD2.text = cryptoDetail.rank_delta
            binding.txtDetailHigh2.text = cryptoDetail.high
            binding.txtDetailHighT2.text = cryptoDetail.high_timestamp

            binding.ibEnviarCorreo.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.data = Uri.parse("mailto:")
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL, "ventas@anchorBooks.cl")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta por libro")
                intent.putExtra(Intent.EXTRA_TEXT, "Hola \n" +
                        "Quisiera pedir información sobre esta moneda " + cryptoDetail.name +", me gustaría que me contactaran a " +
                        "este correo o al siguiente número _________")
                startActivity(intent)}
        })
        }





}