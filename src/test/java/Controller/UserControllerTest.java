package Controller;

import Database.MockDatabase;
import Database.User;
import Resources.UserResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    UserController userController;
    MockDatabase mockDatabase;
    UserResource userResource;
    User user;
    UUID id;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        mockDatabase = new MockDatabase();
        userController = new UserController(mockDatabase);
        userResource = new UserResource("Vester", "Carmen", "bsp@gmx.de",
                "123", "456", 862437600, 1, 5000);
        user = new User("Vester", "Carmen", "bsp@gmx.de",
                "123", "456", 862437600, 1, 5000);
    }

    @Test
    void adduser() {
        String expected = userController.adduser(userResource);
        assertEquals("rediret:/user/null", expected);
    }

    @Test
    void showUserList() {
        String expected = userController.showUserList();
        assertEquals("index", expected);
    }

    @Test
    void showUserById() {
        String expected = userController.showUserById(id);
        assertEquals("user/id", expected);
    }

    @Test
    void updateUser() {
        String expected = userController.updateUser(id, user);
        assertEquals("redirect:/index", expected);
    }

    @Test
    void deleteUser() {
        String expected = userController.deleteUser(id);
        assertEquals("redirect:/index", expected);
    }
}