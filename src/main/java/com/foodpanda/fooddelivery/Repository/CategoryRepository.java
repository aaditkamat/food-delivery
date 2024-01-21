package com.foodpanda.fooddelivery.Repository;


import com.foodpanda.fooddelivery.Entity.Category;
import com.foodpanda.fooddelivery.Entity.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {
    // Each category has a unique name
    Optional<Category> findByName(String name);

    // A product can be assigned to many different categories
    List<Category> findByProduct(Dish product);
}
