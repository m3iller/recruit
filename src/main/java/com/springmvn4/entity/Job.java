package com.springmvn4.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "jobs", schema = "public")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job jobs = (Job) o;
        return id.equals(jobs.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
