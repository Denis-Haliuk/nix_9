package ua.alevel.view.dto.request;

import ua.alevel.persistence.entity.Course;

public class GroupRequestDto extends DtoRequest {

    private String groupName;
    private String teacherName;
    private Course course;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
