package com.github.arisaksen.squeal.controller

import com.github.arisaksen.squeal.SpringProfile
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Profile
import org.testcontainers.junit.jupiter.Testcontainers
import java.sql.SQLException
import javax.sql.DataSource
import org.testcontainers.containers.PostgreSQLContainer

@Testcontainers
@TestConfiguration
@Profile(SpringProfile.LOCAL)
class LocalApplicationConfig {
    companion object {
        const val POSTGRES_PORT = 5432
        val postgresSQLContainer = PostgreSQLContainer("postgres:14").apply {
            withExposedPorts(POSTGRES_PORT)
            withDatabaseName("mydb")
            withUsername("postgres")
            withPassword("postgres")
        }
    }

    @Bean
    @Throws(SQLException::class)
    fun dataSource(): DataSource {
        val hikariConfig = HikariConfig().apply {
            val portMapping = postgresSQLContainer.getMappedPort(POSTGRES_PORT)
            jdbcUrl = "jdbc:postgresql://localhost:${portMapping}/${postgresSQLContainer.databaseName}"
            username = postgresSQLContainer.username
            password = postgresSQLContainer.password
            isAllowPoolSuspension = true
        }

        return HikariDataSource(hikariConfig)
    }
}
