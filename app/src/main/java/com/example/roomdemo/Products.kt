package com.example.roomdemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Products (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String,
    var price: Int
    )