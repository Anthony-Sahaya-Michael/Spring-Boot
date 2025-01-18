package com.examly.springapp;


import java.io.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testCreateAuthor() throws Exception {
        String postJson = "{\"id\": 1, \"name\": \"Test Post\"}";
        mockMvc.perform(post("/author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    public void testSaveBook() throws Exception {
        String commentJson = "{\"id\": 1, \"title\": \"Test Comment\"}";
        mockMvc.perform(post("/author/1/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(commentJson))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(3)
    public void testGetAllPosts() throws Exception {
        mockMvc.perform(get("/author"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void testGetCommentsWithPostId() throws Exception {
        mockMvc.perform(get("/author/1"))
                .andExpect(status().isOk());
    }

   @Test
@Order(5)
public void testUpdateBookTitle() throws Exception {
    String newTitle = "Updated Title";
    String updateJson = "{\"title\": \"" + newTitle + "\"}";
    mockMvc.perform(put("/author/1/book/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(updateJson))
            .andExpect(status().isOk());
}



	 @Test
    public void testControllerFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/controller";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testControllerFile() {
        String filePath = "src/main/java/com/examly/springapp/controller/ApiController.java";
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
        String filePath = "src/main/java/com/examly/springapp/model/Book.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testModelFile1() {
        String filePath = "src/main/java/com/examly/springapp/model/Author.java";
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
        String filePath = "src/main/java/com/examly/springapp/repository/AuthorRepo.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testRepositoryFile1() {
        String filePath = "src/main/java/com/examly/springapp/repository/BookRepo.java";
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
        String filePath = "src/main/java/com/examly/springapp/service/ApiService.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }


}
