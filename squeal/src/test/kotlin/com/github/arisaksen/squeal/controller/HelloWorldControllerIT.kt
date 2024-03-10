package com.github.arisaksen.squeal.controller

import com.github.arisaksen.squeal.SpringProfile
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = [SpringProfile.LOCAL])
class HelloWorldControllerIT {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        mockMvc.get("/hello") {

        }.andDo { print() }
            .andExpect { status { isOk() } }
            .andExpect { content { json("""{"text":"Hello world"}""") } }
            .andExpect { content { json("""{"test":"halo world"}""") } }
    }

}
