package com.courses.subd.service;

import com.courses.subd.dao.CourseDao;
import com.courses.subd.dao.GroupDao;
import com.courses.subd.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkCalculatorService {
    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final GroupDao groupDao;
    @Autowired
    public MarkCalculatorService(StudentDao studentDao, CourseDao courseDao, GroupDao groupDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.groupDao = groupDao;
    }

    public Double CalculateMean(String courseName, String groupName){
        Long courseId = courseDao.findByName(courseName).getCourseId();
        Long groupId = groupDao.findByName(groupName).getGroupId();
        List<Integer> students = studentDao.findByCourseAndGroup(courseId, groupId);
        return students.stream().map(Integer::doubleValue)
                .reduce(0.0, Double::sum)/students.size();
    }

}
