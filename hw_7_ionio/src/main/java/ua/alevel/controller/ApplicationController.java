package ua.alevel.controller;

import ua.alevel.controllers.AuthorController;
import ua.alevel.controllers.BookController;
import ua.alevel.view.Menu;
import ua.alevel.controllers.BookAuthorsController;


public class ApplicationController {
    private BookController bookController;
    private AuthorController authorController;
    private BookAuthorsController bookAuthorsController;

    public ApplicationController() {
        this.bookController = new BookController();
        this.authorController = new AuthorController();
        this.bookAuthorsController = new BookAuthorsController();
    }

    public void runApplication() {
        while (true) {
            int menu = Menu.menuFirstLevel();
            switch (menu) {
                case 0:
                    System.exit(0);
                case 1:
                    bookController.book();
                    break;
                case 2:
                    authorController.author();
                    break;
                case 3:
                    bookAuthorsController.bookAuthor();
                    break;
            }
        }

    }
}
