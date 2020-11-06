package com.home.manageService.lifeManage.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import com.home.manageService.lifeManage.models.entities.Store;

/**
 * @Package : com.home.manageService.lifeManage.repositories
 * @FileName : StoreRepository.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description : 
 */
 
@RepositoryRestResource
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

  Optional<List<Store>> findAllByDel(boolean del);

  Optional<Store> findByIdAndDel(Long id, boolean del);

  @RestResource(exported = false)
  Optional<Store> findByIdAndUserIdAndDel(long storeId, long userId, boolean del);

  Optional<List<Store>> findAllByUserIdAndDel(long userId, boolean del);
}
