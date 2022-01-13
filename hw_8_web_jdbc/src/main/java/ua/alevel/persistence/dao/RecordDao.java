package ua.alevel.persistence.dao;

import ua.alevel.persistence.entity.Record;

public interface RecordDao extends BaseDao<Record> {

    void deleteByGroupId(Long groupId);

    void deleteByStudentId(Long studentId);
}
