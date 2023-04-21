package com.courses.subd.repository;

import com.courses.subd.model.GroupEm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class GroupEntityRepositoryImpl implements GroupEntityRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(GroupEm group){
        em.persist(group);
    }

    @Override
    @Transactional
    public void update(GroupEm group){
        em.merge(group);
    }
    @Override
    @Transactional
    public void delete(GroupEm group){
        em.remove(group);
    }

    @Override
    public GroupEm findGroupById(int groupId) {
        return (GroupEm) em.createQuery("FROM GroupEm groupEm WHERE groupEm.id = :id")
                .setParameter("id", groupId)
                .getSingleResult();
    }

    @Override
    public GroupEm findByName(String name) {
        return em.createQuery("SELECT g FROM Group g WHERE g.name = :name", GroupEm.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
