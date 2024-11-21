package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionTypeService {

    private final ActionTypeRepository actionTypeRepository;

    @Autowired
    public ActionTypeService(ActionTypeRepository actionTypeRepository) {
        this.actionTypeRepository = actionTypeRepository;
    }

    public List<ActionType> getAllActionTypes() {
        return actionTypeRepository.findAll();
    }

    public Optional<ActionType> getActionTypeById(Long id) {
        return actionTypeRepository.findById(id);
    }

    public ActionType createActionType(ActionType actionType) {
        return actionTypeRepository.save(actionType);
    }

    public ActionType updateActionType(Long id, ActionType updatedActionType) {
        Optional<ActionType> existingActionTypeOpt = actionTypeRepository.findById(id);
        if (existingActionTypeOpt.isPresent()) {
            ActionType existingActionType = existingActionTypeOpt.get();
            existingActionType.setNombreAccion(updatedActionType.getNombreAccion());
            return actionTypeRepository.save(existingActionType);
        } else {
            throw new RuntimeException("Action type not found with id " + id);
        }
    }

    public void deleteActionType(Long id) {
        actionTypeRepository.deleteById(id);
    }
}
