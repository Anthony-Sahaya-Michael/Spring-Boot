package com.examly.springapp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClassroomApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    // Test case for POST /api/classroom (Create Classroom)
    @Order(1)
    @Test
    void testPostClassroom() throws Exception {
        String requestBody = "{\"classroomId\": 1, \"className\": \"Math101\", \"capacity\": 30}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/classroom")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.className").value("Math101"))
                .andExpect(jsonPath("$.capacity").value(30));
    }

    // Test case for POST /api/trainer/classroom/{classroomId} (Assign Trainer to Classroom)
    @Order(2)
    @Test
    void testAssignTrainerToClassroom() throws Exception {
        String requestBody = "{\"trainerId\": 1, \"trainerName\": \"Alice\", \"expertise\": \"Mathematics\", \"email\": \"alice@example.com\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/trainer/classroom/{classroomId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.trainerName").value("Alice"))
                .andExpect(jsonPath("$.expertise").value("Mathematics"))
                .andExpect(jsonPath("$.email").value("alice@example.com"));
    }

    // Test case for GET /api/classroom/{classroomId} (Get Classroom by ID)
    @Order(3)
    @Test
    void testGetClassroomById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/classroom/{classroomId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.classroomId").value(1))
                .andExpect(jsonPath("$.trainer").exists());
    }

    // Test case for GET /api/classroom (Get all Classrooms)
    @Order(4)
    @Test
    void testGetAllClassrooms() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/classroom")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    // Test case for GET /api/trainer/expertise/{expertise} (Get Trainers by Expertise)
    @Order(5)
    @Test
    void testGetTrainersByExpertise() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trainer/expertise/{expertise}", "Mathematics")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    // Test case for DELETE /api/trainer/{trainerId} (Delete Trainer by ID)
    @Order(6)
    @Test
    void testDeleteTrainerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/trainer/{trainerId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Trainer 1 deleted successfully"));
    }

    // Test case for DuplicateClassroomException
    @Order(7)
    @Test
    void testDuplicateClassroomException() throws Exception {
        String duplicateClassroomJson = "{\"classroomId\": 1, \"className\": \"Math101\", \"capacity\": 30}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/classroom")
                .contentType(MediaType.APPLICATION_JSON)
                .content(duplicateClassroomJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andExpect(content().string("Classroom with name Math101 already exists!"));
    }

    // Test case for InvalidTrainerIdException
    @Order(8)
    @Test
    void testInvalidTrainerIdException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/trainer/{trainerId}", 99)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Trainer with ID 99 not found."));
    }
    // Check if controller folder exists
    @Test
public void testControllerFolder() {
    String directoryPath = "src/main/java/com/examly/springapp/controller";
    File directory = new File(directoryPath);
    assertTrue(directory.exists() && directory.isDirectory());
}

// Check if ClassroomController.java and TrainerController.java files exist
@Test
public void testControllerFiles() {
    String classroomControllerPath = "src/main/java/com/examly/springapp/controller/ClassroomController.java";
    String trainerControllerPath = "src/main/java/com/examly/springapp/controller/TrainerController.java";

    File classroomControllerFile = new File(classroomControllerPath);
    File trainerControllerFile = new File(trainerControllerPath);

    assertTrue(classroomControllerFile.exists() && classroomControllerFile.isFile());
    assertTrue(trainerControllerFile.exists() && trainerControllerFile.isFile());
}

// Check if model folder exists
@Test
public void testModelFolder() {
    String directoryPath = "src/main/java/com/examly/springapp/model";
    File directory = new File(directoryPath);
    assertTrue(directory.exists() && directory.isDirectory());
}

// Check if Classroom.java and Trainer.java files exist
@Test
public void testModelFiles() {
    String classroomFilePath = "src/main/java/com/examly/springapp/model/Classroom.java";
    String trainerFilePath = "src/main/java/com/examly/springapp/model/Trainer.java";

    File classroomFile = new File(classroomFilePath);
    File trainerFile = new File(trainerFilePath);

    assertTrue(classroomFile.exists() && classroomFile.isFile());
    assertTrue(trainerFile.exists() && trainerFile.isFile());
}

// Check if repository folder exists
@Test
public void testRepositoryFolder() {
    String directoryPath = "src/main/java/com/examly/springapp/repository";
    File directory = new File(directoryPath);
    assertTrue(directory.exists() && directory.isDirectory());
}

// Check if ClassroomRepo.java and TrainerRepo.java files exist
@Test
public void testRepositoryFiles() {
    String classroomRepoPath = "src/main/java/com/examly/springapp/repository/ClassroomRepo.java";
    String trainerRepoPath = "src/main/java/com/examly/springapp/repository/TrainerRepo.java";

    File classroomRepoFile = new File(classroomRepoPath);
    File trainerRepoFile = new File(trainerRepoPath);

    assertTrue(classroomRepoFile.exists() && classroomRepoFile.isFile());
    assertTrue(trainerRepoFile.exists() && trainerRepoFile.isFile());
}

// Check if service folder exists
@Test
public void testServiceFolder() {
    String directoryPath = "src/main/java/com/examly/springapp/service";
    File directory = new File(directoryPath);
    assertTrue(directory.exists() && directory.isDirectory());
}

// Check if ClassroomService.java and TrainerService.java files exist
@Test
public void testServiceFiles() {
    String classroomServicePath = "src/main/java/com/examly/springapp/service/ClassroomService.java";
    String trainerServicePath = "src/main/java/com/examly/springapp/service/TrainerService.java";

    File classroomServiceFile = new File(classroomServicePath);
    File trainerServiceFile = new File(trainerServicePath);

    assertTrue(classroomServiceFile.exists() && classroomServiceFile.isFile());
    assertTrue(trainerServiceFile.exists() && trainerServiceFile.isFile());
}

}
