package com.teceats.teceatsapi.controller;

import com.teceats.teceatsapi.model.RestaurantOwner;
import com.teceats.teceatsapi.service.RestaurantOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.security.Principal;

@RestController
@RequestMapping("/api/restaurant-owners")
public class RestaurantOwnerController {

    private final RestaurantOwnerService restaurantOwnerService;

    @Autowired
    public RestaurantOwnerController(RestaurantOwnerService restaurantOwnerService) {
        this.restaurantOwnerService = restaurantOwnerService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantOwner>> getAllRestaurantOwners() {
        List<RestaurantOwner> owners = restaurantOwnerService.getAllRestaurantOwners();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantOwner> getRestaurantOwnerById(@PathVariable Long id) {
        Optional<RestaurantOwner> owner = restaurantOwnerService.getRestaurantOwnerById(id);
        return owner.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/me")
    public ResponseEntity<RestaurantOwner> getCurrentRestaurantOwner(Principal principal) {
        String email = principal.getName();
        Optional<RestaurantOwner> owner = restaurantOwnerService.getRestaurantOwnerByEmail(email);
        return owner.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/register")
    public ResponseEntity<RestaurantOwner> createRestaurantOwner(@RequestBody RestaurantOwner restaurantOwner) {
        RestaurantOwner newOwner = restaurantOwnerService.createRestaurantOwner(restaurantOwner);
        return new ResponseEntity<>(newOwner, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantOwner> updateRestaurantOwner(@PathVariable Long id, @RequestBody RestaurantOwner updatedRestaurantOwner) {
        try {
            RestaurantOwner owner = restaurantOwnerService.updateRestaurantOwner(id, updatedRestaurantOwner);
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantOwner(@PathVariable Long id) {
        restaurantOwnerService.deleteRestaurantOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}