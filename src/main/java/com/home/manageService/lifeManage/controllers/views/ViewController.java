package com.home.manageService.lifeManage.controllers.views;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.home.manageService.lifeManage.services.UserService;

/**
 * @Package : com.home.manageService.lifeManage.controllers.views
 * @FileName : ViewController.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description : view controller 
 */
 
@RequestMapping("/view")
@Controller
public class ViewController {
	
	private final UserService userService;
	
	public ViewController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("")
	public String main(Model model) {
		model.addAttribute("currentPage", "home");
		return "content/main";
	}
	
	@GetMapping("/users")
	public String selectUsers(Model model, @PageableDefault(page=0, size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("users", userService.findAll(pageable));
		model.addAttribute("currentPage", "user");
		return "content/user";
	}
}
