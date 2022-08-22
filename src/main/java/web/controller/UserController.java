package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String showAll(Model model) {
        List<User> allUsers = userService.allUsers();
        model.addAttribute("allUsers", allUsers);
        return "index";
    }

    @RequestMapping(value = "/add")
    public String addNewUser(Model model) {
        model.addAttribute("newUser", new User());
        return "user-add";
    }

    @RequestMapping(value = "/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit")
    public String editUser(@RequestParam Long id,
                           Model model) {
        model.addAttribute("editUser", userService.get(id));
        return "user-edit";
    }

    @RequestMapping(value = "/update")
    public String updateUser(@ModelAttribute("editUser") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
