package com.github.arisaksen.squeal

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource


@SpringBootApplication
class SquealApplication

fun main(args: Array<String>) {
    runApplication<SquealApplication>(*args)
}

@Configuration
@Profile("!${SpringProfile.LOCAL}")
class SquealApplicationConfiguration {

    @Bean
    fun dataSource(): DataSource {
        val hikariConfig = HikariConfig().apply {
            jdbcUrl = "jdbc:postgresql://localhost:5432/dvdrental"
            username = "arne.isaksen"
            password = "postgres"
            leakDetectionThreshold = 30000
        }
        return HikariDataSource(hikariConfig)
    }
}

object SpringProfile {
    const val LOCAL = "LOCAL"
}

