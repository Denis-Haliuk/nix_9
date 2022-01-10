package ua.alevel.controllers;

import ua.alevel.entity.Author;
import ua.alevel.entity.Fiction;
import ua.alevel.impl.*;
import ua.alevel.service.AuthorService;
import ua.alevel.service.BookAuthorService;
import ua.alevel.service.BookService;
import ua.alevel.util.ConsoleHelper;
import ua.alevel.impl.*;

import java.util.Objects;

public class BookAuthorsController {
    private static final BookConsoleServiceImpl bookConsoleService = new BookConsoleServiceImpl();
    private static final AuthorConsoleServiceImpl authorConsoleService = new AuthorConsoleServiceImpl();
    private static final BookService<Fiction> bookService = new FictionServiceImpl();
    private static final AuthorService authorService = new AuthorServiceImpl();
    private static final BookAuthorService bookAuthorService = new BookAuthorsServiceImpl();

    public void bookAuthor() {
        boolean flag = true;
        while (flag) {
            int option = ConsoleHelper.menuBookAuthor();
            switch (option) {
                case 0: {
                    flag = false;
                    break;
                }
                case 1: {
                    System.out.println("Choose the author: ");
                    String authorId = authorConsoleService.getID();
                    Author author = authorService.findById(authorId);
                    System.out.println("Choose the book: ");
                    String bookTitle = bookConsoleService.getTitle();
                    Fiction fiction = bookService.findByTitle(bookTitle);
                    if (Objects.nonNull(author) && Objects.nonNull(fiction))
                        bookAuthorService.addBookToAuthor(fiction, author);
                    break;
                }

            }
        }
    }

}
