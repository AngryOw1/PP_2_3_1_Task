package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("users4display", userService.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id, Model model){
        model.addAttribute("users4display", userService.showUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("newUser") User user){
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/";
    }

}
