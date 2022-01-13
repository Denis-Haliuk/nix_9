package ua.alevel.service;

import ua.alevel.persistence.datatable.DataTableRequest;
import ua.alevel.persistence.datatable.DataTableResponse;
import ua.alevel.persistence.entity.Student;

import java.util.List;

public interface StudentService extends BaseService<Student> {

    DataTableResponse<Student> findByGroupId(DataTableRequest dataTableRequest, Long groupId);

    List<Student> findAll();
}
