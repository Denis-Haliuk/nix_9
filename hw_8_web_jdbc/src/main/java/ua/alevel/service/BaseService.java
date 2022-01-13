package ua.alevel.service;

import ua.alevel.persistence.datatable.DataTableRequest;
import ua.alevel.persistence.datatable.DataTableResponse;
import ua.alevel.persistence.entity.BaseEntity;

public interface BaseService<ENTITY extends BaseEntity> {

    void create(ENTITY entity);

    void update(ENTITY entity);

    void delete(Long id);

    ENTITY findById(Long id);

    DataTableResponse<ENTITY> findAll(DataTableRequest request);
}
