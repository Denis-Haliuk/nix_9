package ua.alevel.service;

import ua.alevel.persistence.entity.Course;
import ua.alevel.persistence.entity.Student;

import java.util.Set;

public interface StudentService extends BaseService<Student> {
    Set<Course> findCourseStudents(Long id);

    void assignCourse(Long courseId, Long studentId);

    void unassignCourse(Long courseId, Long studentId);
}
