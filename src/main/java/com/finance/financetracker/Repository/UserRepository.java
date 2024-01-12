package com.finance.financetracker.Repository;

import com.finance.financetracker.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface UserRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByUsername(String username);
    List<User> findByDateJoined(LocalDateTime dateJoined);
    List<User> findById(long id);
}
