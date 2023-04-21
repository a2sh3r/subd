package com.courses.subd.repository;

import com.courses.subd.model.CourseEm;
import com.courses.subd.model.GroupEm;
import com.courses.subd.model.StudentEm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class StudentEntityRepositoryImpl implements StudentEntityRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(StudentEm student){
        em.persist(student);
    }

    @Override
    @Transactional
    public void update(StudentEm student){
        em.merge(student);
    }
    @Override
    @Transactional
    public void delete(StudentEm student){
        em.remove(student);
    }

    @Override
    public StudentEm findStudentById(int id) {
        return (StudentEm) em.createQuery("FROM StudentEm studentEm WHERE studentEm.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<StudentEm> findStudentByGroupAndCourse(CourseEm course, GroupEm group) {
        return em.createQuery(
                        "SELECT s FROM StudentEm s WHERE :course MEMBER OF s.courses AND s.group = :group", StudentEm.class)
                .setParameter("course", course)
                .setParameter("group", group)
                .getResultList();
    }

    @Override
    public double calculateAverageMark(CourseEm course, GroupEm group){
        List<StudentEm> students = findStudentByGroupAndCourse(course, group);
        if (students.isEmpty()){return 0.0;}

        double sum = 0.0;
        for (StudentEm student : students){
            sum += student.getMark();
        }
        return sum/ students.size();
    }

}
