package com.dk.coinpriceapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dk.coinpriceapp.db.entity.SelectedCoinPriceEntity

@Dao
interface SelectedCoinPriceDAO {

    //getAllData
    @Query("SELECT * FROM selected_coin_price_table")
    fun getAllData(): List<SelectedCoinPriceEntity>

    //insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(selectedCoinPriceEntity: SelectedCoinPriceEntity)

    //하나의 코인의 저장된 정보를 가져오는 쿼리
    @Query("SELECT * FROM selected_coin_price_table WHERE coinName = :coinName")
    fun getOneCoinData(coinName : String) : List<SelectedCoinPriceEntity>
}