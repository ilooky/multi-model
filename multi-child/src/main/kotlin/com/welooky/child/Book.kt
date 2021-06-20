package com.welooky.child

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "书")
data class Book(
    @ApiModelProperty
    val id: Long,
    @ApiModelProperty("作者名")
    val author: String,
    @ApiModelProperty(name = "name", value = "书名")
    val name: String
)
