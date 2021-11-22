package ua.alevel.service;

import ua.alevel.entity.BaseEntity;

import java.util.Collection;

public interface BaseService<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String id);
    ENTITY findById(String id);
    Collection<ENTITY> findAll();
}
