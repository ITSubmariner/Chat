package com.pet.chat;

import com.pet.chat.controller.GroupController;
import com.pet.chat.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ChatApplicationTests {
    @Autowired private UserController userController;
    @Autowired private GroupController groupController;

    @Autowired private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(userController).isNotNull();
        assertThat(groupController).isNotNull();
    }

    @Test
    void mvcTest() throws Exception {
        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content("{\"username\":\"admin\", \"password\": \"password\"}")).andExpect(status().isOk());
        mockMvc.perform(post("/group").contentType(MediaType.APPLICATION_JSON).content("{\"name\": \"primary\", \"admin_id\": 1}")).andExpect(status().isOk());
        mockMvc.perform(get("/group")).andExpect(status().isOk());
//        mockMvc.perform(post("/group/1/message").contentType(MediaType.APPLICATION_JSON).content("{\"user_id\": 1, \"text\": \"Hello all\"}")).andExpect(status().isOk());
        mockMvc.perform(get("/group/1/message")).andExpect(status().isOk());
    }

}
