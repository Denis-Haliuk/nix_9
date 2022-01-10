package ua.alevel.service;

import ua.alevel.entity.Author;
import ua.alevel.entity.Book;


public interface BookAuthorService {

    void addBookToAuthor(Book book, Author author);

}
