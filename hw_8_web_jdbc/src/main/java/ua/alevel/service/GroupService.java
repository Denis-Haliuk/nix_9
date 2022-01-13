package ua.alevel.service;

import ua.alevel.persistence.datatable.DataTableRequest;
import ua.alevel.persistence.datatable.DataTableResponse;
import ua.alevel.persistence.entity.Group;

import java.util.List;

public interface GroupService extends BaseService<Group> {

    DataTableResponse<Group> findByStudentId(DataTableRequest dataTableRequest, Long studentId);

    List<Group> findAll();
}
