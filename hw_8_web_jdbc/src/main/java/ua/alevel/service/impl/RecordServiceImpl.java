package ua.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.alevel.service.RecordService;
import ua.alevel.exception.EntityNotFoundException;
import ua.alevel.persistence.dao.RecordDao;
import ua.alevel.persistence.datatable.DataTableRequest;
import ua.alevel.persistence.datatable.DataTableResponse;
import ua.alevel.persistence.entity.Record;

@Service
public class RecordServiceImpl implements RecordService {

    private final RecordDao recordDao;

    public RecordServiceImpl(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    public void create(Record entity) {
        recordDao.create(entity);
    }

    @Override
    public void update(Record entity) {
        if (!recordDao.existById(entity.getId())) {
            throw new EntityNotFoundException("record not found");
        }
        recordDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        if (!recordDao.existById(id)) {
            throw new EntityNotFoundException("record not found");
        }
        recordDao.delete(id);
    }

    @Override
    public Record findById(Long id) {
        if (recordDao.existById(id)) {
            return recordDao.findById(id);
        }
        throw new EntityNotFoundException("record not found");
    }

    @Override
    public DataTableResponse<Record> findAll(DataTableRequest request) {
        DataTableResponse<Record> dataTableResponse = recordDao.findAll(request);
        dataTableResponse.setItemsSize(recordDao.count());
        return dataTableResponse;
    }
}
