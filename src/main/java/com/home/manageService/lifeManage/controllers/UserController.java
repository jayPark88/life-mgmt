package com.home.manageService.lifeManage.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.home.manageService.lifeManage.models.entities.User;
import com.home.manageService.lifeManage.models.values.UserValue;
import com.home.manageService.lifeManage.services.UserService;

/**
 * @Package : com.home.manageService.lifeManage.controllers
 * @FileName : UserController.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description : user Controller 
 */
 
@RequestMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public Map<String, Object> findById(@PathVariable("id") long id) {
    Map<String, Object> response = new HashMap<>();

    Optional<User> oUser = userService.findById(id);
    if (oUser.isPresent()) {
      response.put("result", "SUCCESS");
      response.put("user", oUser.get());
    } else {
      response.put("result", "FAIL");
      response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
    }

    return response;
  }

  @PostMapping("")
  public Map<String, Object> save(@RequestBody UserValue value) {
    Map<String, Object> response = new HashMap<>();

    User user = userService.save(value);
    if (user != null) {
      response.put("result", "SUCCESS");
      response.put("user", user);
    } else {
      response.put("result", "FAIL");
      response.put("reason", "회원 가입 실패");
    }

    return response;
  }

  @PatchMapping("/{id}")
  public Map<String, Object> patch(@PathVariable("id") User user, @RequestBody UserValue value) {
    Map<String, Object> response = new HashMap<>();

    if (user != null && !user.isDel()) {
      userService.patch(user, value);
      response.put("result", "SUCCESS");
      response.put("user", user);
    } else {
      response.put("result", "FAIL");
      response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
    }

    return response;
  }

  @DeleteMapping("/{id}")
  public Map<String, Object> delete(@PathVariable("id") User user) {
    Map<String, Object> response = new HashMap<>();

    if (user != null && !user.isDel()) {
      userService.delete(user);
      response.put("result", "SUCCESS");
    } else {
      response.put("result", "FAIL");
      response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
    }

    return response;
  }

}
