package com.courses.subd.repository;

import com.courses.subd.model.GroupEm;

public interface GroupEntityRepository{

    void add(GroupEm group);
    void update(GroupEm group);
    void delete(GroupEm group);
    GroupEm findGroupById(int id);
    GroupEm findByName(String name);
}
