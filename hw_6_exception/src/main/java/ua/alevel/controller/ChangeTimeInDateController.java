package ua.alevel.controller;

import ua.alevel.db.DBInMemory;
import ua.alevel.impl.CalendarServiceImpl;
import ua.alevel.impl.DateServiceImpl;
import ua.alevel.impl.MenuServiceImpl;
import ua.alevel.persistence.entity.Date;
import ua.alevel.persistence.type.CalendarType;
import ua.alevel.persistence.type.DateFormatType;
import ua.alevel.service.CalendarService;
import ua.alevel.service.DateService;
import ua.alevel.service.MenuService;
import ua.alevel.util.ConsoleUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChangeTimeInDateController {
    private static final int DATA_FORMAT_CHOOSE_OPTION = 2;
    private static final int CALENDAR_TYPE_CHOOSE_OPTION = 3;
    private static final int DATE_QUANTITY = 1;
    private static final DBInMemory db = DBInMemory.getInstance();

    DateService dateService;
    MenuService menuService;
    CalendarService calendarService;

    public ChangeTimeInDateController() {
        this.dateService = new DateServiceImpl();
        menuService = new MenuServiceImpl();
        calendarService = new CalendarServiceImpl();
    }

    public void changeTime(int function) {
        dateService.dateFormatMenu();
        int optionDataFormatTypeMenu = menuService.chooseOption(DATA_FORMAT_CHOOSE_OPTION);
        ConsoleUtil.takeDatesFromUser(DATE_QUANTITY, optionDataFormatTypeMenu);

        menuService.calendarTypeMenu();
        int optionCalendarTypeMenu = menuService.chooseOption(CALENDAR_TYPE_CHOOSE_OPTION);
        CalendarType calendarType = calendarService.getCalendarType(optionCalendarTypeMenu);
        long time = menuService.readMilliseconds(calendarType);
        List<Date> dates = db.findAllDates();
        Date date = dates.get(0);
        Date changeTimeInDate;
        if (function == 1) {
            changeTimeInDate = calendarService.addTimeToDate(date, time, calendarType);
        } else {
            changeTimeInDate = calendarService.subtractionTimeFromDate(date, time, calendarType);
        }
        if (changeTimeInDate == null) {
            return;
        }
        dates.clear();

        Optional<DateFormatType> dateFormatType = Arrays.stream(DateFormatType.values())
                .filter(d -> d.getDateFormat() == optionDataFormatTypeMenu)
                .findFirst();
        dateFormatType.ifPresent(type -> menuService.output(changeTimeInDate.toString(type)));
    }
}
