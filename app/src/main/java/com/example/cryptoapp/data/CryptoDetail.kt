package com.example.cryptoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail")
data class CryptoDetail(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "currency") val currency: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "logo_url") val logo_url: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "price_date") val price_date: String,
    @ColumnInfo(name = "price_timestamp") val price_timestamp: String,
    @ColumnInfo(name = "circulating_supply") val circulating_supply: String,
    @ColumnInfo(name = "market_cap") val market_cap: String,
    @ColumnInfo(name = "num_exchanges") val num_exchanges: String,
    @ColumnInfo(name = "num_pairs") val num_pairs: String,
    @ColumnInfo(name = "num_pairs_unmapped") val num_pairs_unmapped: String,
    @ColumnInfo(name = "first_candle") val first_candle: String,
    @ColumnInfo(name = "first_trade") val first_trade: String,
    @ColumnInfo(name = "first_order_book") val first_order_book: String,
    @ColumnInfo(name = "rank") val rank: String,
    @ColumnInfo(name = "rank_delta") val rank_delta: String,
    @ColumnInfo(name = "high") val high: String,
    @ColumnInfo(name = "high_timestamp") val high_timestamp: String,
    @ColumnInfo(name = "the1D") val the1D: The1D)
{

}
@Entity(tableName = "1D")
data class The1D (
    @ColumnInfo(name = "volume") val volume: String,
    @ColumnInfo(name = "price_change") val price_change: String,
    @ColumnInfo(name = "price_change_pct") val price_change_pct: String,
    @ColumnInfo(name = "volume_change") val volume_change: String,
    @ColumnInfo(name = "volume_change_pct") val volume_change_pct: String,
    @ColumnInfo(name = "market_cap_change") val market_cap_change: String,
    @ColumnInfo(name = "market_cap_change_pct") val market_cap_change_pct: String
)
{

}
