package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	void testRegisterUser() throws Exception {
		String requestBody = "{\"username\": \"Adminuser\", \"password\": \"user123\", \"role\": \"ADMIN\"}";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andReturn();
	}

	@Test
	@Order(2)
	void testLoginEndpoint() throws Exception {
		String requestBody = "{\"username\": \"AdminUser\", \"password\": \"user123\"}";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String token = result.getResponse().getContentAsString();
		assertNotNull(token);
	}
	
	@Test
	public void testUserControllerFile() {
		String filePath = "src/main/java/com/examly/springapp/controller/UserController.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}


	@Test
	public void testModelFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/model";
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	
	@Test
	public void testModelFile() {
		String filePath = "src/main/java/com/examly/springapp/model/User.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testRepositoryFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/repository";
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testRepositoryFile() {
		String filePath = "src/main/java/com/examly/springapp/repository/UserRepo.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testServiceFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/service";
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testServiceFile() {
		String filePath = "src/main/java/com/examly/springapp/service/UserService.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testConfigurationFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/configuration";
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testConfigurationFile() {
		String filePath = "src/main/java/com/examly/springapp/configuration/SecurityConfig.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

}
