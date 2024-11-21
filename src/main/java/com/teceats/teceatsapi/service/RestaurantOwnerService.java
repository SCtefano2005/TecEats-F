package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantOwnerService {

    private final RestaurantOwnerRepository restaurantOwnerRepository;

    @Autowired
    public RestaurantOwnerService(RestaurantOwnerRepository restaurantOwnerRepository) {
        this.restaurantOwnerRepository = restaurantOwnerRepository;
    }

    public Optional<RestaurantOwner> getRestaurantOwnerByEmail(String email) {
        return restaurantOwnerRepository.findByEmail(email);
    }

    public List<RestaurantOwner> getAllRestaurantOwners() {
        return restaurantOwnerRepository.findAll();
    }

    public Optional<RestaurantOwner> getRestaurantOwnerById(Long id) {
        return restaurantOwnerRepository.findById(id);
    }

    public RestaurantOwner createRestaurantOwner(RestaurantOwner restaurantOwner) {
        return restaurantOwnerRepository.save(restaurantOwner);
    }

    public RestaurantOwner updateRestaurantOwner(Long id, RestaurantOwner updatedRestaurantOwner) {
        Optional<RestaurantOwner> existingOwnerOpt = restaurantOwnerRepository.findById(id);
        if (existingOwnerOpt.isPresent()) {
            RestaurantOwner existingOwner = existingOwnerOpt.get();
            existingOwner.setNombre(updatedRestaurantOwner.getNombre());
            existingOwner.setEmail(updatedRestaurantOwner.getEmail());
            existingOwner.setTelefono(updatedRestaurantOwner.getTelefono());
            return restaurantOwnerRepository.save(existingOwner);
        } else {
            throw new RuntimeException("RestaurantOwner not found with id " + id);
        }
    }

    public void deleteRestaurantOwner(Long id) {
        restaurantOwnerRepository.deleteById(id);
    }
}
