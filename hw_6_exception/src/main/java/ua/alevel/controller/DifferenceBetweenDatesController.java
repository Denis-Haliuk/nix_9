package ua.alevel.controller;

import ua.alevel.db.DBInMemory;
import ua.alevel.impl.CalendarServiceImpl;
import ua.alevel.impl.DateServiceImpl;
import ua.alevel.impl.MenuServiceImpl;
import ua.alevel.persistence.entity.Date;
import ua.alevel.persistence.type.CalendarType;
import ua.alevel.service.CalendarService;
import ua.alevel.service.DateService;
import ua.alevel.service.MenuService;
import ua.alevel.util.ConsoleUtil;

import java.math.BigInteger;
import java.util.List;

public class DifferenceBetweenDatesController {
    private static final int DATA_FORMAT_CHOOSE_OPTION = 2;
    private static final int CALENDAR_TYPE_CHOOSE_OPTION = 3;
    private static final int QUANTITY_DATES = 2;
    private static final DBInMemory db = DBInMemory.getInstance();
    MenuService menuService;
    DateService dateService;
    CalendarService calendarService;

    public DifferenceBetweenDatesController() {
        menuService = new MenuServiceImpl();
        dateService = new DateServiceImpl();
        calendarService = new CalendarServiceImpl();
    }

    public void differenceBetweenDates() {
        dateService.dateFormatMenu();
        int optionDataFormatTypeMenu = menuService.chooseOption(DATA_FORMAT_CHOOSE_OPTION);

        System.out.println("Finding difference between two dates:");
        ConsoleUtil.takeDatesFromUser(QUANTITY_DATES, optionDataFormatTypeMenu);
        menuService.calendarTypeMenu();
        int optionCalendarTypeMenu = menuService.chooseOption(CALENDAR_TYPE_CHOOSE_OPTION);
        CalendarType calendarType = calendarService.getCalendarType(optionCalendarTypeMenu);

        List<Date> dates = db.findAllDates();
        BigInteger difference = calendarService.findDifferenceBetweenDates(dates.get(0), dates.get(1), calendarType);
        dates.clear();
        if (difference.equals(-1)) {
            differenceBetweenDates();
            return;
        }
        menuService.output(String.valueOf(difference));

    }

}
