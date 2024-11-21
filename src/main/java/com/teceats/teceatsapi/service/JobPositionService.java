package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionService {

    private final JobPositionRepository jobPositionRepository;

    @Autowired
    public JobPositionService(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    public List<JobPosition> getAllJobPositions() {
        return jobPositionRepository.findAll();
    }

    public Optional<JobPosition> getJobPositionById(Long id) {
        return jobPositionRepository.findById(id);
    }

    public JobPosition createJobPosition(JobPosition jobPosition) {
        return jobPositionRepository.save(jobPosition);
    }

    public JobPosition updateJobPosition(Long id, JobPosition updatedJobPosition) {
        Optional<JobPosition> existingJobPositionOpt = jobPositionRepository.findById(id);
        if (existingJobPositionOpt.isPresent()) {
            JobPosition existingJobPosition = existingJobPositionOpt.get();
            existingJobPosition.setNombreCargo(updatedJobPosition.getNombreCargo());
            return jobPositionRepository.save(existingJobPosition);
        } else {
            throw new RuntimeException("Job position not found with id " + id);
        }
    }

    public void deleteJobPosition(Long id) {
        jobPositionRepository.deleteById(id);
    }
}
