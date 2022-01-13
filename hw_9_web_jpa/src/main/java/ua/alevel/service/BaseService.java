package ua.alevel.service;

import ua.alevel.persistence.datatable.DataTableRequest;
import ua.alevel.persistence.datatable.DataTableResponse;
import ua.alevel.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseService<ENT extends BaseEntity> {

    void create(ENT ent);

    void update(ENT ent);

    void delete(Long id);

    ENT findById(Long id);

    List<ENT> findAll();

    DataTableResponse<ENT> findAll(DataTableRequest request);
}
