package com.github.arisaksen.squeal.service

import com.github.arisaksen.squeal.repository.HelloProvider
import org.springframework.stereotype.Service

@Service
class HelloService(
    private val helloProvider: HelloProvider
) {

    fun getHello(): Any {
        val world = "world"
        val hello = helloProvider.getHello()

        return object {
            val text = "$hello $world"
            val test = "halo $world"
        }
    }
}