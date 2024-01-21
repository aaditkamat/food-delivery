package com.foodpanda.fooddelivery.Repository;

import com.foodpanda.fooddelivery.Entity.Photo;
import com.foodpanda.fooddelivery.Entity.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface PhotoRepository extends CrudRepository<Photo, UUID> {
    // Each photo is uniquely identified by a hash code
    Optional<Photo> findByHashCode(long hashCode);

    // Dishes do not share photos, so each photo is
    // uniquely assigned to a dish
    Optional<Photo> findByDish(Dish dish);
}
