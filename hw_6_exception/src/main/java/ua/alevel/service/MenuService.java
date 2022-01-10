package ua.alevel.service;

import ua.alevel.persistence.type.CalendarType;

public interface MenuService {
    void mainMenu();

    int chooseOption(int section);

    void calendarTypeMenu();

    void output(String result);

    long readMilliseconds(CalendarType calendarType);

}
