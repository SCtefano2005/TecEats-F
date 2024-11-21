package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Optional<Restaurant> existingRestaurantOpt = restaurantRepository.findById(id);
        if (existingRestaurantOpt.isPresent()) {
            Restaurant existingRestaurant = existingRestaurantOpt.get();
            existingRestaurant.setNombre(updatedRestaurant.getNombre());
            existingRestaurant.setDireccion(updatedRestaurant.getDireccion());
            existingRestaurant.setTelefono(updatedRestaurant.getTelefono());
            existingRestaurant.setHabilitado(updatedRestaurant.getHabilitado());
            return restaurantRepository.save(existingRestaurant);
        } else {
            throw new RuntimeException("Restaurant not found with id " + id);
        }
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
