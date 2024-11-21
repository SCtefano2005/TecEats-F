package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Optional<Dish> getDishById(Long id) {
        return dishRepository.findById(id);
    }

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish updateDish(Long id, Dish updatedDish) {
        Optional<Dish> existingDishOpt = dishRepository.findById(id);
        if (existingDishOpt.isPresent()) {
            Dish existingDish = existingDishOpt.get();
            existingDish.setNombre(updatedDish.getNombre());
            existingDish.setDescripcion(updatedDish.getDescripcion());
            existingDish.setPrecio(updatedDish.getPrecio());
            existingDish.setImagen(updatedDish.getImagen());
            return dishRepository.save(existingDish);
        } else {
            throw new RuntimeException("Dish not found with id " + id);
        }
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
