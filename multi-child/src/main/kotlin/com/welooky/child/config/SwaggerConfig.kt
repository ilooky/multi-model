package com.welooky.child.config

import com.fasterxml.classmate.TypeResolver
import io.swagger.annotations.Api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ResponseBuilder
import springfox.documentation.schema.AlternateTypeRules
import springfox.documentation.schema.WildcardType
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.time.LocalDate
import javax.annotation.Resource

/**
 *
@Api： 用于类，标识这个类是swagger的资源
@ApiIgnore： 用于类，忽略该 Controller，指不对当前类做扫描
@ApiOperation： 用于方法，描述 Controller类中的 method接口
@ApiParam： 用于参数，单个参数描述，与 @ApiImplicitParam不同的是，他是写在参数左侧的。如（ @ApiParam(name="username",value="用户名")Stringusername）
@ApiModel： 用于类，表示对类进行说明，用于参数用实体类接收
@ApiProperty：用于方法，字段，表示对model属性的说明或者数据操作更改
@ApiImplicitParam： 用于方法，表示单独的请求参数
@ApiImplicitParams： 用于方法，包含多个 @ApiImplicitParam
@ApiResponse： 用于方法，描述单个出参信息
@ApiResponses： 用于方法，包含多个@ApiResponse
@ApiError： 用于方法，接口错误所返回的信息
 */
@Configuration
class SwaggerConfig {
    @Resource
    private lateinit var typeResolver: TypeResolver

    @Bean
    fun docket(): Docket? {
        return Docket(DocumentationType.OAS_30)
            .apiInfo(
                ApiInfoBuilder()
                    .title("围观世界接口文档")
                    .description("围观世界APP后端接口文档")
                    .version("0.0.1-SNAPSHOT")
                    .license("MIT")
                    .licenseUrl("https://opensource.org/licenses/MIT")
                    .build()
            )
            .securitySchemes(arrayListOf())
//            .useDefaultResponseMessages(false)
//            .globalResponses(
//                HttpMethod.GET, arrayListOf(
//                    ResponseBuilder().code("500").description("Internal error!").build(),
//                    ResponseBuilder().code("403").description("Forbidden!").build()
//                )
//            )
            .select().apis(RequestHandlerSelectors.withClassAnnotation(Api::class.java))
            .paths(PathSelectors.any())
            .build()
            .alternateTypeRules(
                AlternateTypeRules.newRule(
                    typeResolver.resolve(Mono::class.java, WildcardType::class.java),
                    typeResolver.resolve(WildcardType::class.java)
                ),
                AlternateTypeRules.newRule(
                    typeResolver.resolve(Flux::class.java, WildcardType::class.java),
                    typeResolver.resolve(WildcardType::class.java)
                )
            )
            .directModelSubstitute(LocalDate::class.java, String::class.java)
    }
}