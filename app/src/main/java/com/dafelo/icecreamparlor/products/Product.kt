package com.dafelo.icecreamparlor.products

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("name1") val name: String = "",
    @SerializedName("name2") val alternativeName: String,
    @SerializedName("price") val price: String,
    @SerializedName("bg_color") val backgroundColor: String,
    @SerializedName("type") val type: String
) {
}