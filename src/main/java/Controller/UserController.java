package Controller;

import Database.User;
import Repository.UserRepository;
import Resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Registirerung neuer User

    @PostMapping("/adduser")
    UserResource register (@Valid @RequestBody UserResource userResource) {
        User user = new User(userResource.getTxt_name(),
                userResource.getTxt_first_name(),
                userResource.getTxt_email(),
                userResource.getTxt_password_hash(),
                userResource.getTxt_password_salt(),
                userResource.getDat_unix_birthday(),
                userResource.getBool_student(),
                userResource.getFloat_money_amount());

        return new UserResource(
                user.getTxt_name(),
                user.getTxt_first_name(),
                user.getTxt_email(),
                user.getTxt_password_hash(),
                user.getTxt_password_salt(),
                user.getDat_unix_birthday(),
                user.getBool_student(),
                user.getFloat_money_amount()
        );
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        userRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/index";
    }
}
