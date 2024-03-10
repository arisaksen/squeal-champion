package com.github.arisaksen.squeal.repository

import org.springframework.stereotype.Repository

@Repository
class HelloProvider {

    fun getHello(): String = "Hello"

}