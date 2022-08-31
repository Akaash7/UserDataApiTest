package com.akash.userdataapplication.data.remote.dto

data class DataDTO(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)