package com.example.springapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
@Order(1)
void testGetAllAlbums_NoContent() throws Exception {
    // First, ensure the database is empty or clear any existing data
    // You might need to clear the data manually or use a test setup method to ensure an empty database state

    mockMvc.perform(MockMvcRequestBuilders.get("/album")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent()) // Expect 204 No Content
            .andReturn();
}
    @Test
    @Order(2)
    void testAddAlbum() throws Exception {
        String albumJson = "{\"albumId\": 1, \"albumName\": \"Thriller\", \"artistName\": \"Michael Jackson\", \"releaseYear\": 1982}";
        mockMvc.perform(MockMvcRequestBuilders.post("/album")
                .contentType(MediaType.APPLICATION_JSON)
                .content(albumJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.albumName").value("Thriller"))
                .andReturn();
    }

    @Test
    @Order(3)
    void testGetAllAlbums() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/album")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.albumName == 'Thriller')]").exists())
                .andReturn();
    }

    @Test
    @Order(4)
    void testGetAlbumById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/album/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.albumName").value("Thriller"))
                .andReturn();
    }
    // Test 4: Get album by ID and expect 404 Not Found
    @Test
    @Order(5)
    void testGetAlbumById_NotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/album/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()) // Expect 404 Not Found
                .andExpect(content().string("Album not found")) // Expect string message
                .andReturn();
    }
    
    @Test
@Order(6)
void testAddAlbum_BadRequest() throws Exception {
    // Create an invalid request with empty albumName and artistName
    String invalidAlbumJson = "{\"albumId\": 2, \"albumName\": \"\", \"artistName\": \"\", \"releaseYear\": 1982}";

    mockMvc.perform(MockMvcRequestBuilders.post("/album")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidAlbumJson)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest()) // Expect 400 Bad Request
            .andReturn();
}


}
