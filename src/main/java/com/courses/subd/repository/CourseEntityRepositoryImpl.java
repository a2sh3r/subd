package com.courses.subd.repository;

import com.courses.subd.model.CourseEm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class CourseEntityRepositoryImpl implements CourseEntityRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(CourseEm course){
        em.persist(course);
    }

    @Override
    @Transactional
    public void update(CourseEm course){
        em.merge(course);
    }
    @Override
    @Transactional
    public void delete(CourseEm course){
        em.remove(course);
    }

    @Override
    public CourseEm findCourseById(int courseId) {
        return (CourseEm) em.createQuery("FROM CourseEm courseEm WHERE courseEm.id = :id")
                .setParameter("id", courseId)
                .getSingleResult();
    }

    @Override
    public CourseEm findByName(String name) {
        return em.createQuery("SELECT g FROM Group g WHERE g.name = :name", CourseEm.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
