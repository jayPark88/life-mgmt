package com.home.manageService.lifeManage.controllers.views;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @Package : com.home.manageService.lifeManage.controllers.views
 * @FileName : LoginController.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description :login controller 
 */
 
@Controller
public class LoginController {

  @GetMapping(value = "/")
  public String index(@AuthenticationPrincipal User user) {
    if (user != null) {
      if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_VIEW"))) {
        return "redirect:/view";
      }
    }
    return "redirect:/login";
  }

  @GetMapping(value = "/login")
  public String login(@AuthenticationPrincipal User user) {
    if (user != null) {
      if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_VIEW"))) {
        return "redirect:/view";
      }
    }
    return "login/login";
  }

}
