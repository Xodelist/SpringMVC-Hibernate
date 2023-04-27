package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService service;

	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}
	@GetMapping
	public String showUsers(Model model) {
		model.addAttribute("users",service.getUsers());
		return "/users/show";
	}
	@GetMapping("/{id}")
	public String showUser(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("user",service.getUser(id));
		return "/users/page";
	}

	@GetMapping("/new")
	public String addUserPage(Model model) {
		model.addAttribute("user", new User());
		return "/users/new";
	}
	@GetMapping("/{id}/edit")
	public String editUserPage(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("user",service.getUser(id));
		return "users/edit";
	}
	@PatchMapping("/{id}/edit")
	public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Integer id) {
		service.editUser(user,id);
		return "redirect:/users";
	}

	@PostMapping
	public String addUser(@ModelAttribute("user") User user) {
		service.addUser(user);
		return "redirect:/users";
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		service.deleteUser(id);
		return "redirect:/users";
	}

	
}