package ua.alevel.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.BookAuthorDao;
import ua.alevel.entity.Author;
import ua.alevel.entity.Book;
import ua.alevel.entity.Fiction;
import ua.alevel.service.BookAuthorService;

public class BookAuthorsServiceImpl implements BookAuthorService {
    private final static Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class.getName());
    private final BookAuthorDao bookAuthorDao = new BookAuthorDao();
    @Override
    public void addBookToAuthor(Book book, Author author) {
        logger.info("Start to add a book to the author");
        if (book != null && author != null) {
           bookAuthorDao.add((Fiction) book,author);
            logger.info("Success add a book to the author");
        } else logger.info("Book wasn't added cause parameters are wrong");
    }

}
