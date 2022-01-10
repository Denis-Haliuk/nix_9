package ua.alevel.dao;

import ua.alevel.entity.Fiction;
import ua.alevel.service.BaseDao;
import ua.alevel.db.DBInCSV;

import java.util.Set;

public class BookDao implements BaseDao<Fiction> {
  private final DBInCSV db = DBInCSV.getInstance();

    @Override
    public void create(Fiction fiction) {
        db.createBook(fiction);
    }

    @Override
    public void update(Fiction fiction) {
        db.updateBook(fiction);
    }

    @Override
    public void delete(String id) {
        db.deleteBook(id);
    }

    @Override
    public Fiction find(String id) {
        return db.findBookById(id);
    }

    @Override
    public Set<Fiction> findAll() {
        return db.findAllBooks();
    }

    public Fiction findByTitle(String title) {
        return db.findBookByTitle(title);
    }

    public boolean exist(String title ){
        return db.existBookByTitle(title);
    }

}
