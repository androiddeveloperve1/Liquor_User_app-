package com.liquoruser.model.testModels.filter

data class FilterModel(
    var filterTypeName: String?,
    var filterItems: ArrayList<FilterItemModel>?,
    var isFilterTypeShowing: Boolean?,
    var isFilterTypeViewShowing: Boolean?
)