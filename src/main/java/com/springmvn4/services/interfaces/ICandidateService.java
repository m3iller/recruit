package com.springmvn4.services.interfaces;

import com.springmvn4.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface ICandidateService {

     List<Candidate> findAllCustom(String name, String linkedin);
     Optional<Candidate> findById(int id);
     Candidate save(Candidate candidates);
     void deleteById(int id);

}