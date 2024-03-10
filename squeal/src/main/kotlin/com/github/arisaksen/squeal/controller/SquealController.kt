package com.github.arisaksen.squeal.controller

import com.github.arisaksen.squeal.service.SquealService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SquealController(
    private val squealService: SquealService
) {

    @GetMapping("/squeal")
    fun getSqueal() =
        squealService.getHello()

}