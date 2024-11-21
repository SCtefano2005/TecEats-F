package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;

    @Autowired
    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    public Optional<Approval> getApprovalById(Long id) {
        return approvalRepository.findById(id);
    }

    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    public Approval updateApproval(Long id, Approval updatedApproval) {
        Optional<Approval> existingApprovalOpt = approvalRepository.findById(id);
        if (existingApprovalOpt.isPresent()) {
            Approval existingApproval = existingApprovalOpt.get();

            // Actualiza los campos del objeto Approval existente con los datos del objeto actualizado.
            existingApproval.setIdAdmin(updatedApproval.getIdAdmin());
            existingApproval.setIdRestaurante(updatedApproval.getIdRestaurante());
            existingApproval.setIdAccion(updatedApproval.getIdAccion());
            existingApproval.setFechaAccion(updatedApproval.getFechaAccion());
            existingApproval.setObservaciones(updatedApproval.getObservaciones());

            // Guarda la aprobación actualizada en la base de datos
            return approvalRepository.save(existingApproval);
        } else {
            throw new RuntimeException("Approval not found with id " + id);
        }
    }

    public void deleteApproval(Long id) {
        approvalRepository.deleteById(id);
    }
}