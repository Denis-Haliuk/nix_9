package ua.alevel.persistence.dao;

import ua.alevel.persistence.entity.Course;
import ua.alevel.persistence.entity.Student;

import java.util.List;
import java.util.Set;

public interface CourseDao extends BaseDao<Course> {
    Set<Student> findCourseStudents(Long id);

    void assignStudent(Long courseId, Long studentId);

    void unassignStudent(Long courseId, Long studentId);
}
