package com.foodpanda.fooddelivery.Repository;

import com.foodpanda.fooddelivery.Entity.Address;
import com.foodpanda.fooddelivery.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface AddressRepository extends CrudRepository<Address, UUID> {
    // A user can order food in only one location at a time
    Optional<Address> findByUser(User user);

    // There can be several buildings along the same street,
    // each of which has a seperate address
    List<Address> findByStreet(String street);

    // There can be a building with the same block details in
    // more than one location
    List<Address> findByBlock(String block);

    // There are usually multiple buildings in one zip code
    // that have seperate addresses
    List<Address> findByZipCode(int zipCode);
}
