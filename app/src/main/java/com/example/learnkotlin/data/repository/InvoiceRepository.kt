package com.example.learnkotlin.data.repository

import com.example.learnkotlin.data.model.Invoice

/**
 * Repository cung cấp dữ liệu hóa đơn.
 * Hiện tại dùng fake data, sau này có thể thay bằng API hoặc Database.
 */
class InvoiceRepository {

    fun getInvoices(): List<Invoice> {
        return listOf(
            Invoice(
                id = "HD001",
                date = "2026-07-01",
                totalAmount = 1_500_000,
                itemName = "Laptop Dell Inspiron 15"
            ),
            Invoice(
                id = "HD002",
                date = "2026-07-05",
                totalAmount = 350_000,
                itemName = "Chuột Logitech G102"
            ),
            Invoice(
                id = "HD003",
                date = "2026-07-10",
                totalAmount = 2_800_000,
                itemName = "Màn hình Samsung 24 inch"
            ),
            Invoice(
                id = "HD004",
                date = "2026-07-15",
                totalAmount = 120_000,
                itemName = "Bàn phím cơ Akko 3068"
            ),
            Invoice(
                id = "HD005",
                date = "2026-07-18",
                totalAmount = 750_000,
                itemName = "Tai nghe Sony WH-1000XM4"
            )
        )
    }
}
