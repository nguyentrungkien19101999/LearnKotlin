package com.example.learnkotlin.data.model

/**
 * Model - đại diện cho 1 hóa đơn
 */
data class Invoice(
    val id: String,
    val date: String,
    val totalAmount: Long,
    val itemName: String
)
