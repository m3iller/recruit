package com.springmvn4.controllers;

import com.springmvn4.entity.Candidate;
import com.springmvn4.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidatesService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllCandidate(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String linkedin) {

        List<Candidate> candidates = candidatesService.findAllCustom(name, linkedin);
        return ResponseEntity.status(HttpStatus.OK).body(candidates);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCandidateById(@PathVariable Integer id) {

        Optional<Candidate> candidate = candidatesService.findById(id);
        return candidate.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(candidate.get()) :
                 ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<?> postCandidate(@RequestBody Candidate postCandidate) {

        Candidate candidate = candidatesService.save(postCandidate);
        return ResponseEntity.status(HttpStatus.OK).body(candidate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCandidateById(@PathVariable Integer id) {
        candidatesService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("")
    public ResponseEntity<?> putCandidate(@RequestBody Candidate postCandidate) {

        Candidate candidate = candidatesService.save(postCandidate);
        return ResponseEntity.status(HttpStatus.OK).body(candidate);
    }


}
