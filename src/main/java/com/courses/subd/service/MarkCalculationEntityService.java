package com.courses.subd.service;

import com.courses.subd.repository.CourseEntityRepositoryImpl;
import com.courses.subd.repository.GroupEntityRepositoryImpl;
import com.courses.subd.repository.StudentEntityRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkCalculationEntityService {
    private final StudentEntityRepositoryImpl studentDao;
    private final CourseEntityRepositoryImpl courseDao;
    private final GroupEntityRepositoryImpl groupDao;
    @Autowired
    public MarkCalculationEntityService(StudentEntityRepositoryImpl studentDao, CourseEntityRepositoryImpl courseDao, GroupEntityRepositoryImpl groupDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.groupDao = groupDao;
    }

//    public Double CalculateMean(String courseName, String groupName){
//        int courseId = courseDao.findCourseByName(courseName).getCourseId();
//        int groupId = groupDao.findGroupByName(groupName).getGroupId();
//        List<StudentEm> students = studentDao.findStudentByGroupAndCourse(courseId, groupId);
//
//        return students.stream().map(StudentEm::getMark).map(Integer::doubleValue)
//                .reduce(0.0, Double::sum)/students.size();
//    }
}
