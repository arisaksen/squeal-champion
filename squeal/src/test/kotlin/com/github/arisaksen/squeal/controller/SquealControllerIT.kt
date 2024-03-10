package com.github.arisaksen.squeal.controller

import com.github.arisaksen.squeal.controller.LocalApplicationConfig.Companion.postgresSQLContainer
import com.github.arisaksen.squeal.SpringProfile
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = [SpringProfile.LOCAL])
class SquealControllerIT {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeAll
    fun beforeAll() {
        postgresSQLContainer.start()
    }

    @Test
    @Order(1)
    fun test1() {
        mockMvc.get("/squeal") {

        }.andDo { print() }
            .andExpect { status { isOk() } }
            .andExpect { content { json("""{"text":"Hello world"}""") } }
            .andExpect { content { json("""{"test":"halo world"}""") } }
    }

    @Test
    @Order(2)
    fun test2() {
        mockMvc.get("/squeal") {

        }.andDo { print() }
            .andExpect { status { isOk() } }
            .andExpect { content { json("""{"text":"Hello world"}""") } }
            .andExpect { content { json("""{"test":"halo world"}""") } }
    }

    @Test
    @Order(3)
    fun test3() {
        mockMvc.get("/squeal") {

        }.andDo { print() }
            .andExpect { status { isOk() } }
            .andExpect { content { json("""{"text":"Hello world"}""") } }
            .andExpect { content { json("""{"test":"halo world"}""") } }
    }

    @AfterAll
    fun afterAll() {
        postgresSQLContainer.stop()
    }

}
