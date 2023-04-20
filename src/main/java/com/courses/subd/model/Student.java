package com.courses.subd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENTS")
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SECOND_NAME", nullable = false)
    private String secondName;
    @Column(name = "FIRST_NAME",nullable = false)
    private String firstName;
    @Column(name = "BATYA_NAME",nullable = false)
    private String batyaName;

//    @Column(name = "group_name",nullable = false)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "studentId")
//    private Group studentGroup;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "groupId")
    private Group studentGroup;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "courseId")
    private Course courses;

    @Column(name = "mark")
    private Integer mark;
}
