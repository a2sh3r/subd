package com.courses.subd.repository;

import com.courses.subd.model.GroupEm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepJac extends JpaRepository<GroupEm, Long>, GroupEntityRepository{
}
