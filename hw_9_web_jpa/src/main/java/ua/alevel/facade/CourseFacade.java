package ua.alevel.facade;

import ua.alevel.view.dto.request.CourseRequestDto;
import ua.alevel.view.dto.response.CourseResponseDto;
import ua.alevel.view.dto.response.StudentResponseDto;

import java.util.List;

public interface CourseFacade extends BaseFacade<CourseRequestDto, CourseResponseDto>{

    List<StudentResponseDto> findCourseStudents(Long id);

    void assignStudent(Long courseId, Long studentId);

    void unassignStudent(Long courseId, Long studentId);
}
