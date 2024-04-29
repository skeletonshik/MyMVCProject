package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public String showAllUsers(Model model)    {

        List<User> allUsers = userService.getUsers();
        model.addAttribute("users", allUsers);
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addUser(Model model)    {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";

    }
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user)    {

        userService.saveUSer(user);

        return "redirect:/all";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") long id, Model model)    {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "update";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long id, Model model)    {

        userService.deleteUser(id);

        return "redirect:/all";
    }

}
