package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Optional<Administrator> getAdministratorById(Long id) {
        return administratorRepository.findById(id);
    }

    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Administrator updateAdministrator(Long id, Administrator updatedAdministrator) {
        Optional<Administrator> existingAdministratorOpt = administratorRepository.findById(id);
        if (existingAdministratorOpt.isPresent()) {
            Administrator existingAdministrator = existingAdministratorOpt.get();
            existingAdministrator.setNombre(updatedAdministrator.getNombre());
            existingAdministrator.setEmail(updatedAdministrator.getEmail());
            existingAdministrator.setTelefono(updatedAdministrator.getTelefono());
            return administratorRepository.save(existingAdministrator);
        } else {
            throw new RuntimeException("Administrator not found with id " + id);
        }
    }

    public void deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);
    }
}
