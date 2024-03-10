package com.github.arisaksen.squeal.service

import com.github.arisaksen.squeal.repository.SquealProvider
import org.springframework.stereotype.Service

@Service
class SquealService(
    private val squealProvider: SquealProvider
) {

    fun getHello(): Any {
        val world = "world"
        val hello = squealProvider.getHello()

        return object {
            val text = "$hello $world"
            val test = "halo $world"
        }
    }
}