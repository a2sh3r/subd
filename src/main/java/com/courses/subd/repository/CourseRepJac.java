package com.courses.subd.repository;

import com.courses.subd.model.CourseEm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepJac extends JpaRepository<CourseEm, Long>, CourseEntityRepository{
}
