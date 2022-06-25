package Controller;

import Database.User;
import Repository.UserRepository;
import Resources.UserResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository userRepository;

    UserResource user;

    @BeforeEach
    void setUp() {
        user = new UserResource("Vester", "Carmen",
                "bsp@gmx.de","123",
                "456", 862437600,
                1, 5000);
    }

    @Test
    void whenValidInput() throws Exception {
        UserResource user1 = new UserResource("Vester", "Carmen",
                "bsp@gmx.de","123",
                "456", 862437600,
                1, 5000);
        mockMvc.perform(post("/user/adduser").content(objectMapper.writeValueAsString(user1)).contentType("application/json")).andExpect(status().isOk());
    }

    @Test
    void addUser() {
    }

    @Test
    void showUserList() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}
