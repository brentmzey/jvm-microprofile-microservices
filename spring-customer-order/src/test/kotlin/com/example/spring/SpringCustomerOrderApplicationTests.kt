package com.example.spring

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@Testcontainers
class SpringCustomerOrderApplicationTests {

	companion object {
		@Container
		val postgresqlContainer = PostgreSQLContainer("postgres:16-alpine").apply {
			withDatabaseName("testdb")
			withUsername("testuser")
			withPassword("testpass")
		}

		@Container
		val mongoDBContainer = MongoDBContainer("mongo:7.0").apply {
			withExposedPorts(27017)
		}

		@JvmStatic
		@DynamicPropertySource
		fun dynamicProperties(registry: DynamicPropertyRegistry) {
			registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl)
			registry.add("spring.datasource.username", postgresqlContainer::getUsername)
			registry.add("spring.datasource.password", postgresqlContainer::getPassword)

			registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl)
		}
	}

	@Test
	fun contextLoads() {
		// This test will now run against the temporary databases
	}

}
