package com.example.learnkotlin.ui.invoice

import androidx.lifecycle.ViewModel
import com.example.learnkotlin.data.repository.InvoiceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel cho màn hình danh sách hóa đơn.
 * Lấy dữ liệu từ Repository và cung cấp cho UI.
 */
class InvoiceViewModel : ViewModel() {

    private val invoiceRepository = InvoiceRepository()

    private val _uiState = MutableStateFlow(InvoiceUiState())
    val uiState: StateFlow<InvoiceUiState> = _uiState.asStateFlow()

    init {
        // Load dữ liệu khi ViewModel được tạo
        loadInvoices()
    }

    private fun loadInvoices() {
        val invoices = invoiceRepository.getInvoices()
        _uiState.value = InvoiceUiState(invoices = invoices)
    }
}
