package com.teceats.teceatsapi.controller;

import com.teceats.teceatsapi.model.JobPosition;
import com.teceats.teceatsapi.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.security.Principal;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping
    public ResponseEntity<List<JobPosition>> getAllJobPositions() {
        List<JobPosition> jobPositions = jobPositionService.getAllJobPositions();
        return new ResponseEntity<>(jobPositions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobPositionById(@PathVariable Long id) {
        Optional<JobPosition> jobPosition = jobPositionService.getJobPositionById(id);
        return jobPosition.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<JobPosition> createJobPosition(@RequestBody JobPosition jobPosition) {
        JobPosition newJobPosition = jobPositionService.createJobPosition(jobPosition);
        return new ResponseEntity<>(newJobPosition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJobPosition(@PathVariable Long id, @RequestBody JobPosition updatedJobPosition) {
        try {
            JobPosition jobPosition = jobPositionService.updateJobPosition(id, updatedJobPosition);
            return new ResponseEntity<>(jobPosition, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosition(@PathVariable Long id) {
        jobPositionService.deleteJobPosition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

