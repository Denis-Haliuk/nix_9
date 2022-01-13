package ua.alevel.service;

import ua.alevel.persistence.entity.Course;
import ua.alevel.persistence.entity.Student;

import java.util.Set;

public interface CourseService extends BaseService<Course> {
    Set<Student> findCourseStudents(Long id);

    void assignStudent(Long courseId, Long studentId);

    void unassignStudent(Long courseId, Long studentId);
}
