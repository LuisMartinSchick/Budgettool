package Controller;

import Database.MockDatabase;
import Database.User;
import Resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    private final MockDatabase mockDatabase;

    @Autowired
    public UserController(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    //Registirerung neuer User
    @PostMapping("/adduser")
    String adduser (@Valid @RequestBody UserResource userResource) {
        User user = new User(userResource.getTxt_name(),
                userResource.getTxt_first_name(),
                userResource.getTxt_email(),
                userResource.getTxt_password_hash(),
                userResource.getTxt_password_salt(),
                userResource.getDat_unix_birthday(),
                userResource.getBool_student(),
                userResource.getFloat_money_amount());

        mockDatabase.saveUser(user);
        String redirect = "rediret:/user/" + user.getId();
        return redirect;
    }

    @GetMapping("/index")
    public String showUserList() {
        mockDatabase.findAllUsers();
        return "index";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") UUID id) {
        mockDatabase.findUserById(id);
        return "user/id";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") UUID id, @Valid User user) {
        mockDatabase.saveUser(user);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") UUID id) {
        mockDatabase.deleteUserById(id);
        return "redirect:/index";
    }
}
