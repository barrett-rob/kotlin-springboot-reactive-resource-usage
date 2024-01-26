package org.example.traditional

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@RestController
@RequestMapping("/api/nextval")
class Controller(
    private val jdbcTemplate: JdbcTemplate,
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun nextval(): Map<String, Long?> {
        val nextval = jdbcTemplate.queryForObject(
            "select nextval('db_seq')",
            Long::class.java,
        )
        return mapOf("nextval" to nextval)
    }
}
