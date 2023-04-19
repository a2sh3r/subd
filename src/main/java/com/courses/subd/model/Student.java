package com.courses.subd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "batya_name",nullable = false)
    private String batyaName;

//    @Column(name = "group_name",nullable = false)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "studentId")
//    private Group studentGroup;
    @ManyToOne
    @JoinColumn(name = "studentList")
    private Group studentGroup;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "studentCourses",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId"))
    private List<Course> courses;

    @Column(name = "mark")
    private Integer mark;
}
