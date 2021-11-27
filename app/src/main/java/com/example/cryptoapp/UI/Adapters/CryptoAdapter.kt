package com.example.cryptoapp.UI.Adapters

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cryptoapp.UI.View.Detalle
import com.example.cryptoapp.data.Crypto
import com.example.cryptoapp.databinding.RecyclerviewCryptoBinding

class CryptoAdapter(private val activity: Activity) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>(){
    private var crypto : List<Crypto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding : RecyclerviewCryptoBinding = RecyclerviewCryptoBinding.inflate(LayoutInflater.from(activity))
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = crypto[position]
        val id = crypto.id
        holder.name.text = crypto.name
        holder.symbol.text = crypto.symbol
        holder.status.text = crypto.status
        holder.price.text = crypto.price
        if(crypto.status == "active")
        {
            holder.status.setTextColor(Color.GREEN)
        }else{
            holder.status.setTextColor(Color.RED)
        }
        holder.rank.text = crypto.rank
        Glide.with(activity).load("https://i.pinimg.com/originals/e2/e7/22/e2e722f3aeb96f9494f0b484e04027cd.png").apply(RequestOptions().override(70,70)).into(holder.image)
        holder.detail.setOnClickListener {
            val siguiente = Intent(activity, Detalle::class.java)
            siguiente.putExtra("id",id)
            activity.startActivity(siguiente)
        }

    }

    override fun getItemCount(): Int {
        return crypto.size
    }
    fun loadCrypto(list: List<Crypto>)
    {
        crypto = list
        notifyDataSetChanged()
    }

    class CryptoViewHolder(view : RecyclerviewCryptoBinding) : RecyclerView.ViewHolder(view.root)
    {
        val name = view.txtNameInfo
        val symbol = view.txtSymbolInfo
        val status = view.txtStatusInfo
        val rank = view.txtRankInfo
        val detail = view.txtRevisar
        val image = view.ivImage
        val price = view.txtPriceInfo
    }
}