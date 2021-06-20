package com.welooky.child

import com.welooky.library.Response
import io.swagger.annotations.*
import kotlinx.coroutines.reactor.mono
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/book")
@Api(tags = ["书架"], description = "书架相关接口")
class Controller {
    @GetMapping("/info/{catalogue}")
    @ApiOperation(value = "根据userId获取用户的信息", notes = "")
    @ApiImplicitParam(
        name = "catalogue",
        value = "目录类型",
        paramType = "path",
        dataType = "string",
        defaultValue = "COMPUTER",
        required = true
    )
    @ApiImplicitParams(
        value = [ApiImplicitParam(
            dataType = "string",
            name = "Authorization",
            value = "jwt token",
            paramType = "header"
        )]
    )
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "successful operation", response = Response::class)
        ]
    )
    fun findBook(
        @PathVariable catalogue: String,
        @ApiParam(value = "书名") name: String,
        @ApiParam(name = "author", value = "作者") author: String,
    ) = mono {
        Response(arrayListOf(Book(100L, "Java Native", "joy")))
    }
}