package com.home.manageService.lifeManage.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.manageService.lifeManage.mapper.MemberMapper;
import com.home.manageService.lifeManage.model.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {

  @Autowired
  private MemberMapper memberMapper;
  
  public List<Member> getMemberList() {
//    log.info("getMemberList member : " + member);
    // TODO Auto-generated method stub
    List<Member> memberList = new ArrayList<Member>();
    try {
      memberList = memberMapper.selectMemberList();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.info("getMemberList error exception : " + e.getMessage());
      e.printStackTrace();
    }
    log.info("memberList success : " + memberList);
    return memberList;
  }
  
}
