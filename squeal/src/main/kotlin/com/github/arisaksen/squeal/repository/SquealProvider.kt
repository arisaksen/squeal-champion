package com.github.arisaksen.squeal.repository

import org.springframework.stereotype.Repository

@Repository
class SquealProvider {

    fun getHello(): String = "Hello"

}