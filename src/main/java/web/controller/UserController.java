package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserServiceImpl;
import web.model.User;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl service;

    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/all")
    public String showAllUsers(Model model) {
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "allUsers";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "newUsers";
    }

    @PostMapping()
    public String createUser( User user) {
        service.saveUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/id/edit")
    public String edit(Model model, @RequestParam("id") long id) {
        model.addAttribute("user",service.getUserById(id));
        return "editit";
    }

    @PatchMapping("/id")
    public String update( User user,@RequestParam("id") long id) {
        service.updateUser(user);
        return "redirect:/users/all";
    }

    @DeleteMapping("/id")
    public String delete(@RequestParam("id") long id) {
        service.deleteUser( id);
        return "redirect:/users/all";
    }
}