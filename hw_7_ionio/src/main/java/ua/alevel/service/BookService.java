package ua.alevel.service;

import ua.alevel.entity.Book;

import java.util.Set;

public interface BookService<B extends Book> {

    void create(B book);

    void update(B book);

    void delete(String id);

    B findById(String id);

    B findByTitle(String title);

    Set<B> findAll();

}
