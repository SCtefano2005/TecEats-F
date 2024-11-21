package com.teceats.teceatsapi.controller;

import com.teceats.teceatsapi.model.Approval;
import com.teceats.teceatsapi.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.security.Principal;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping
    public ResponseEntity<List<Approval>> getAllApprovals() {
        List<Approval> approvals = approvalService.getAllApprovals();
        return new ResponseEntity<>(approvals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable Long id) {
        Optional<Approval> approval = approvalService.getApprovalById(id);
        return approval.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Approval> createApproval(@RequestBody Approval approval) {
        Approval newApproval = approvalService.createApproval(approval);
        return new ResponseEntity<>(newApproval, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable Long id, @RequestBody Approval updatedApproval) {
        try {
            Approval approval = approvalService.updateApproval(id, updatedApproval);
            return new ResponseEntity<>(approval, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable Long id) {
        approvalService.deleteApproval(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}