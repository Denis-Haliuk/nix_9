package ua.alevel.controllers;

import ua.alevel.entity.Author;
import ua.alevel.impl.BookConsoleServiceImpl;
import ua.alevel.impl.FictionServiceImpl;
import ua.alevel.service.AuthorService;
import ua.alevel.util.ConsoleHelper;
import ua.alevel.entity.Fiction;
import ua.alevel.impl.AuthorConsoleServiceImpl;
import ua.alevel.impl.AuthorServiceImpl;
import ua.alevel.service.BookService;

import java.util.Set;

public class AuthorController {
    private static final AuthorService authorService = new AuthorServiceImpl();
    private static final BookService<Fiction> bookService = new FictionServiceImpl();
    private static final AuthorConsoleServiceImpl authorConsoleService = new AuthorConsoleServiceImpl();
    private static final BookConsoleServiceImpl bookConsoleServiceImpl = new BookConsoleServiceImpl();

    public void author() {
        boolean flag = true;
        while (flag) {
            int option = ConsoleHelper.menuAuthor();
            switch (option) {
                case 0: {
                    flag = false;
                    break;
                }
                case 1: {
                    Author author = authorConsoleService.create();
                    authorService.create(author);
                    break;
                }
                case 2: {
                    Author author = authorConsoleService.update();
                    authorService.update(author);
                    break;
                }
                case 3: {
                    String authorID = authorConsoleService.delete();
                    if (authorID != null)
                        authorService.delete(authorID);
                    break;
                }
                case 4: {
                    Set<Author> authorSet = authorService.findAll();
                    authorConsoleService.findAll(authorSet);
                    break;
                }
                case 5: {
                    String title = bookConsoleServiceImpl.getTitle();
                    Fiction fiction = bookService.findByTitle(title);
                    authorConsoleService.findAuthorsByBook(fiction);
                    break;
                }
                case 6: {
                    String authorId = authorConsoleService.getID();
                    Author author = authorService.findById(authorId);
                    authorConsoleService.findById(author);
                    break;
                }
            }
        }
    }
}

