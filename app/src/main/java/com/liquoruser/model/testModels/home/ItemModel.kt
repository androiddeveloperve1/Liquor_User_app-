package com.liquoruser.model.testModels.home

data class ItemModel(
    var itemName: String?,
    var itemImage: Int?,
    var isItemFavorite: Boolean?,
    var itemDealsTitle: String?,
    var itemPrice: String?,
    var itemQuantity: String?,
    var itemRating: Double?,
    var itemReview: String?
)