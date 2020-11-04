package com.home.manageService.lifeManage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.home.manageService.lifeManage.model.Member;
import com.home.manageService.lifeManage.service.MemberService;

/**
 * @Package : com.home.manageService.lifeManage
 * @FileName : HomeController.java
 * @CreateDate : 2020. 11. 3. 
 * @author : 82105
 * @Description : 
 */

@RestController
@RequestMapping("/life/manage")
public class MemberController {

  @Autowired
  private MemberService memberService;
  
  @GetMapping("/memberList")
  public List<Member> getMemberList() {
    return memberService.getMemberList();
  }
}
