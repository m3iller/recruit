package com.springmvn4.repository;

import com.springmvn4.entity.Job;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Integer> {

    @Override
    @Lock(LockModeType.OPTIMISTIC)
    public Optional<Job> findById(Integer integer);

}
