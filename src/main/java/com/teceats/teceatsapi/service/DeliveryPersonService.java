package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DeliveryPersonService {

    private final DeliveryPersonRepository deliveryPersonRepository;

    @Autowired
    public DeliveryPersonService(DeliveryPersonRepository deliveryPersonRepository) {
        this.deliveryPersonRepository = deliveryPersonRepository;
    }

    public List<DeliveryPerson> getAllDeliveryPersons() {
        return deliveryPersonRepository.findAll();
    }

    public Optional<DeliveryPerson> getDeliveryPersonById(Long id) {
        return deliveryPersonRepository.findById(id);
    }

    public DeliveryPerson createDeliveryPerson(DeliveryPerson deliveryPerson) {
        return deliveryPersonRepository.save(deliveryPerson);
    }

    public DeliveryPerson updateDeliveryPerson(Long id, DeliveryPerson updatedDeliveryPerson) {
        Optional<DeliveryPerson> existingDeliveryPersonOpt = deliveryPersonRepository.findById(id);
        if (existingDeliveryPersonOpt.isPresent()) {
            DeliveryPerson existingDeliveryPerson = existingDeliveryPersonOpt.get();
            existingDeliveryPerson.setNombre(updatedDeliveryPerson.getNombre());
            existingDeliveryPerson.setEmail(updatedDeliveryPerson.getEmail());
            existingDeliveryPerson.setTelefono(updatedDeliveryPerson.getTelefono());
            return deliveryPersonRepository.save(existingDeliveryPerson);
        } else {
            throw new RuntimeException("Delivery person not found with id " + id);
        }
    }

    public void deleteDeliveryPerson(Long id) {
        deliveryPersonRepository.deleteById(id);
    }
}
