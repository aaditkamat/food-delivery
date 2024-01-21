package com.foodpanda.fooddelivery.Repository;

import com.foodpanda.fooddelivery.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID>, CrudRepository<User, UUID> {
    // You cannot have the same email associated with two different
    // users registered on the system
    Optional<User> findByEmail(String email);

    // Same logic as email
    Optional<User> findByUsername(String username);

    // There can be two different users that have the same full name
    List<User> findByFullName(String fullName);

    // Each user has a unique phone number assigned to them
    Optional<User> findByPhone(long phone);

    // There can be multiple users that have the same role
    List<User> findByRole(String role);
}
