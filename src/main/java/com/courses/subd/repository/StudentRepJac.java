package com.courses.subd.repository;

import com.courses.subd.model.StudentEm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepJac extends JpaRepository<StudentEm, Long>, StudentEntityRepository{
}
