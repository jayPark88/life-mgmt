package com.home.manageService.lifeManage.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.home.manageService.lifeManage.models.entities.User;

/**
 * @Package : com.home.manageService.lifeManage.repositories
 * @FileName : UserRepository.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description : 
 */
 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findById(Long id);

  List<User> findAllByDel(boolean del);

  List<User> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
