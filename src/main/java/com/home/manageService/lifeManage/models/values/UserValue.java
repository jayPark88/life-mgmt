package com.home.manageService.lifeManage.models.values;

import lombok.Getter;
import lombok.Setter;

/**
 * @Package : com.home.manageService.lifeManage.models.values
 * @FileName : UserValue.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description : user model 
 */
 
@Getter
@Setter
public class UserValue {
  private String type;
  private String email;
  private String name;
  private String sex;
  private String birthDate;
  private String phoneNumber;
  private String password;
}
