package ua.alevel.persistence.dao;

import ua.alevel.persistence.datatable.DataTableRequest;
import ua.alevel.persistence.datatable.DataTableResponse;
import ua.alevel.persistence.entity.Student;

import java.util.List;

public interface StudentDao extends BaseDao<Student> {

    DataTableResponse<Student> findByGroupId(DataTableRequest dataTableRequest, Long groupId);

    long countByGroupId(Long groupId);

    List<Student> findAll();
}
