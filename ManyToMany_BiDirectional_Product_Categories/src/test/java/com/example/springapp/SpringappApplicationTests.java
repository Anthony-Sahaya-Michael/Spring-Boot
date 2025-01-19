package com.example.springapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.File;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testCreateCategory() throws Exception {
        String requestBody = "{\"name\": \"Sample\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    public void testAddProductToCategory() throws Exception {
        String productRequestBody = "{\"name\": \"TestProduct\", \"price\": 10.0}";

        mockMvc.perform(MockMvcRequestBuilders.post("/categories/1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productRequestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(3)
    public void testGetCategoryWithProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sample"))
                .andExpect(jsonPath("$.products[0].name").value("TestProduct"))
                .andExpect(jsonPath("$.products[0].price").value(10.0));
    }

    @Test
    @Order(4)
    public void testGetProductsOrderedByPriceAsc() throws Exception {
        // Adding products to a new category
        String categoryRequestBody = "{\"name\": \"Electronics\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(categoryRequestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        String product1RequestBody = "{\"name\": \"Smartphone\", \"price\": 699.99}";
        String product2RequestBody = "{\"name\": \"Laptop\", \"price\": 999.99}";

        mockMvc.perform(MockMvcRequestBuilders.post("/categories/2/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(product1RequestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders.post("/categories/2/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(product2RequestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders.get("/categories/2/product/asc-price")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Smartphone"))
                .andExpect(jsonPath("$[0].price").value(699.99))
                .andExpect(jsonPath("$[1].name").value("Laptop"))
                .andExpect(jsonPath("$[1].price").value(999.99));
    }

    @Test
    @Order(5)
    public void testDeleteProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/categories/product/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    public void testControllerFolderExists() {
        String directoryPath = "src/main/java/com/example/springapp/controller";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory(), "Controller folder does not exist");
    }

    @Test
    @Order(7)
    public void testControllerFileExists() {
        String filePath = "src/main/java/com/example/springapp/controller/ApiController.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile(), "ApiController.java does not exist");
    }

    @Test
    @Order(8)
    public void testModelFolderExists() {
        String directoryPath = "src/main/java/com/example/springapp/model";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory(), "Model folder does not exist");
    }

    @Test
    @Order(9)
    public void testCategoryModelFileExists() {
        String filePath = "src/main/java/com/example/springapp/model/Category.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile(), "Category.java does not exist");
    }

    @Test
    @Order(10)
    public void testProductModelFileExists() {
        String filePath = "src/main/java/com/example/springapp/model/Product.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile(), "Product.java does not exist");
    }

    @Test
    @Order(11)
    public void testRepositoryFolderExists() {
        String directoryPath = "src/main/java/com/example/springapp/repository";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory(), "Repository folder does not exist");
    }

    @Test
    @Order(12)
    public void testCategoryRepositoryFileExists() {
        String filePath = "src/main/java/com/example/springapp/repository/CategoryRepository.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile(), "CategoryRepository.java does not exist");
    }

    @Test
    @Order(13)
    public void testProductRepositoryFileExists() {
        String filePath = "src/main/java/com/example/springapp/repository/ProductRepository.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile(), "ProductRepository.java does not exist");
    }

    @Test
    @Order(14)
    public void testServiceFolderExists() {
        String directoryPath = "src/main/java/com/example/springapp/service";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory(), "Service folder does not exist");
    }

    @Test
    @Order(15)
    public void testServiceFileExists() {
        String filePath = "src/main/java/com/example/springapp/service/ProductCategoryService.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile(), "ProductCategoryService.java does not exist");
    }
}
