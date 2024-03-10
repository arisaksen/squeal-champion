package com.github.arisaksen.squeal.controller

import com.github.arisaksen.squeal.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService
) {

    /** [Swagger-ui](http://localhost:8080/swagger-ui/index.html)
     * [Swagger docs](https://www.baeldung.com/spring-rest-openapi-documentation) */
    @GetMapping("/hello")
    fun getHelloWorld() =
        helloService.getHello()


}