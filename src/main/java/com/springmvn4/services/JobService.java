package com.springmvn4.services;

import com.springmvn4.entity.Job;
import com.springmvn4.repository.JobRepository;
import jakarta.persistence.LockModeType;
import jakarta.persistence.LockModeType.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobsRepository;

    public List<Job> findAll() {
        return jobsRepository.findAll();
    }

    public Job save(Job jobs) {
        return jobsRepository.save(jobs);
    }

    public Optional<Job> findById(int id) { return jobsRepository.findById(id);}

    public void deleteById(int id) {
        jobsRepository.deleteById(id);
    }


}
