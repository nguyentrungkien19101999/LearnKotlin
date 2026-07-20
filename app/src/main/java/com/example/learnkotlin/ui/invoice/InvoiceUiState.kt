package com.example.learnkotlin.ui.invoice

import com.example.learnkotlin.data.model.Invoice

/**
 * UI State cho màn hình danh sách hóa đơn
 */
data class InvoiceUiState(
    val invoices: List<Invoice> = emptyList()
)
