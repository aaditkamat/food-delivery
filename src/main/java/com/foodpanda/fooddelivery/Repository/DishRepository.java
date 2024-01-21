package com.foodpanda.fooddelivery.Repository;

import com.foodpanda.fooddelivery.Entity.Category;
import com.foodpanda.fooddelivery.Entity.Photo;
import com.foodpanda.fooddelivery.Entity.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DishRepository extends CrudRepository<Dish, UUID> {
    // We will assume that each dish has a unique name
    Optional<Dish> findByName(String name);

    // Several dishes can have the same price
    List<Dish> findByPrice(double price);

    // Each dish has a unique description
    Optional<Dish> findByDescription(String description);

    // When you filter by multiple categories, you can still
    // get multiple dishes listed that can be found at the
    // intersection of those common categories
    List<Dish> findByCategories(List<Category> categories);

    // We assume that the dishes cannot share photos because the photos
    // uniquely identify a dish
    Optional<Dish> findByPhotos(List<Photo> photos);

}
