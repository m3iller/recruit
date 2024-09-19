package com.springmvn4.repository;

import com.springmvn4.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    List<Candidate> findByName(String name);

    List<Candidate> findByLinkedin(String linkedin);
    List<Candidate> findByNameAndLinkedin(String name, String linkedin);
}
