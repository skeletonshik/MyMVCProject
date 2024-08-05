package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String showAllUsers(Model model)    {

        List<User> allUsers = userService.getUsers();
        model.addAttribute("users", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addUser(Model model)    {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";

    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user)    {

        userService.saveUSer(user);

        return "redirect:/all";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") long id, Model model)    {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "update";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user)    {
        userService.updateUser(user);

        return "redirect:/all";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long id, Model model)    {

        userService.deleteUser(id);

        return "redirect:/all";
    }

}
