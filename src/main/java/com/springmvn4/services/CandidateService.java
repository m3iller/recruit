package com.springmvn4.services;

import com.springmvn4.entity.Candidate;
import com.springmvn4.repository.CandidateRepository;
import com.springmvn4.services.interfaces.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateRepository candidatesRepository;

    @Override
    public Candidate save(Candidate candidates) {

        return candidatesRepository.save(candidates);
    }
    @Override
    public Optional<Candidate> findById(int id) {

        return candidatesRepository.findById(id);
    }
    @Override
    public void deleteById(int id) {

        candidatesRepository.deleteById(id);
    }

    @Override
    public List<Candidate> findAllCustom(String name, String linkedin) {
        if(name != null && linkedin != null) {
            return candidatesRepository.findByNameAndLinkedin(name, linkedin);
        }
        if(name != null) {
            return candidatesRepository.findByName(name);
        }
        if(linkedin != null) {
            return candidatesRepository.findByLinkedin(linkedin);
        }
        return candidatesRepository.findAll();
    }
}
