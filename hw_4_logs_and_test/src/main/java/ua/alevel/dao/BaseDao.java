package ua.alevel.dao;

import ua.alevel.entity.BaseEntity;

import java.util.Collection;

public interface BaseDao<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String id);
    ENTITY findById(String id);
    Collection<ENTITY> findAll();
}
