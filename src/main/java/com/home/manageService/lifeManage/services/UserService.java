package com.home.manageService.lifeManage.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.home.manageService.lifeManage.models.entities.User;
import com.home.manageService.lifeManage.models.values.UserValue;
import com.home.manageService.lifeManage.repositories.UserRepository;

/**
 * @Package : com.home.manageService.lifeManage.services
 * @FileName : UserService.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description : user service 
 */
 
@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  @Transactional
  public User save(UserValue value) {
    User user = User.builder().type(value.getType()).email(value.getEmail())
        .birthDate(value.getBirthDate()).name(value.getName()).password(value.getPassword())
        .phoneNumber(value.getPhoneNumber()).sex(value.getSex()).build();

    return userRepository.save(user);
  }

  @Transactional
  public void patch(User user, UserValue value) {
    if (StringUtils.isNotBlank(value.getType()))
      user.setType(value.getType());
    if (StringUtils.isNotBlank(value.getEmail()))
      user.setEmail(value.getEmail());
    if (StringUtils.isNotBlank(value.getBirthDate()))
      user.setBirthDate(value.getBirthDate());
    if (StringUtils.isNotBlank(value.getName()))
      user.setName(value.getName());
    if (StringUtils.isNotBlank(value.getPassword()))
      user.setPassword(value.getPassword());
    if (StringUtils.isNotBlank(value.getPhoneNumber()))
      user.setPhoneNumber(value.getPhoneNumber());
    if (StringUtils.isNotBlank(value.getSex()))
      user.setSex(value.getSex());
  }

  @Transactional
  public void delete(User user) {
    // user.setDel(true);
    userRepository.delete(user);
  }

  public List<User> findAll(Pageable pageable) {
    return userRepository.findAllByDelOrderByIdDesc(false, pageable);
  }
}
