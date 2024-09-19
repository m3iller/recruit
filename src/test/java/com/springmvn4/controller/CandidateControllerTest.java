package com.springmvn4.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvn4.entity.Candidate;
import com.springmvn4.services.CandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CandidateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidateService candidateService;

    @Test
    public void testGetCandidateById_Found() throws Exception {

        Candidate candidate = new Candidate();
        candidate.setId(1);
        candidate.setName("John");
        candidate.setLinkedin("http://linkedin");

        when(candidateService.findById(1)).thenReturn(Optional.of(candidate));

        mockMvc.perform(MockMvcRequestBuilders.get("/candidate/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.linkedin").value("http://linkedin"));
    }

    @Test
    public void testGetCandidateById_NotFound() throws Exception {
        when(candidateService.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/candidate/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testPostCandidate_Found() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        Candidate candidate = new Candidate();
        candidate.setName("John");
        candidate.setLinkedin("http://linkedin");

        when(candidateService.save(candidate)).thenReturn(candidate);

        mockMvc.perform(MockMvcRequestBuilders.post("/candidate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(candidate)))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));

    }


}


