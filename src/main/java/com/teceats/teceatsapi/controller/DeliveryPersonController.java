package com.teceats.teceatsapi.controller;

import com.teceats.teceatsapi.model.DeliveryPerson;
import com.teceats.teceatsapi.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.security.Principal;

@RestController
@RequestMapping("/api/delivery-persons")
public class DeliveryPersonController {

    private final DeliveryPersonService deliveryPersonService;

    @Autowired
    public DeliveryPersonController(DeliveryPersonService deliveryPersonService) {
        this.deliveryPersonService = deliveryPersonService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryPerson>> getAllDeliveryPersons() {
        List<DeliveryPerson> deliveryPersons = deliveryPersonService.getAllDeliveryPersons();
        return new ResponseEntity<>(deliveryPersons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPerson> getDeliveryPersonById(@PathVariable Long id) {
        Optional<DeliveryPerson> deliveryPerson = deliveryPersonService.getDeliveryPersonById(id);
        return deliveryPerson.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DeliveryPerson> createDeliveryPerson(@RequestBody DeliveryPerson deliveryPerson) {
        DeliveryPerson newDeliveryPerson = deliveryPersonService.createDeliveryPerson(deliveryPerson);
        return new ResponseEntity<>(newDeliveryPerson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryPerson> updateDeliveryPerson(@PathVariable Long id, @RequestBody DeliveryPerson updatedDeliveryPerson) {
        try {
            DeliveryPerson deliveryPerson = deliveryPersonService.updateDeliveryPerson(id, updatedDeliveryPerson);
            return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryPerson(@PathVariable Long id) {
        deliveryPersonService.deleteDeliveryPerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}