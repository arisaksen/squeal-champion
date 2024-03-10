package com.github.arisaksen.squeal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class SquealApplication

fun main(args: Array<String>) {
    runApplication<SquealApplication>(*args)
}

object SpringProfile {
    const val LOCAL = "LOCAL"
}

