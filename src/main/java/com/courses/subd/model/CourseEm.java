package com.courses.subd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Setter
@Getter
public class CourseEm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<StudentEm> students;
}
