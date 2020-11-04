package com.home.manageService.lifeManage.mapper;

import java.util.List;
import com.home.manageService.lifeManage.model.Member;

public interface MemberMapper {
  List<Member> selectMemberList();
}
