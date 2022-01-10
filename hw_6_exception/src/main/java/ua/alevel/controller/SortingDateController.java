package ua.alevel.controller;

import ua.alevel.db.DBInMemory;
import ua.alevel.impl.CalendarServiceImpl;
import ua.alevel.impl.DateServiceImpl;
import ua.alevel.impl.MenuServiceImpl;
import ua.alevel.persistence.entity.Date;
import ua.alevel.persistence.type.DateFormatType;
import ua.alevel.service.CalendarService;
import ua.alevel.service.DateService;
import ua.alevel.service.MenuService;
import ua.alevel.util.ConsoleUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SortingDateController {
    private static final DBInMemory db = DBInMemory.getInstance();
    private static final int DATA_FORMAT_CHOOSE_OPTION = 2;
    private MenuService menuService;
    private DateService dateService;
    private CalendarService calendarService;

    public SortingDateController() {
        menuService = new MenuServiceImpl();
        dateService = new DateServiceImpl();
        calendarService = new CalendarServiceImpl();
    }

    public void sortDate() {
        dateService.dateFormatMenu();
        int optionDataFormatTypeMenu = menuService.chooseOption(DATA_FORMAT_CHOOSE_OPTION);

        System.out.println("Sorting dates");
        int quantity = ConsoleUtil.getQuantityFromUser();
        ConsoleUtil.takeDatesFromUser(quantity, optionDataFormatTypeMenu);
        List<Date> dates = db.findAllDates();

        List<Date> sortedDates = calendarService.sort(dates, ConsoleUtil.isSortDatesByIncrease());
        if (sortedDates == null) {
            return;
        }
        Optional<DateFormatType> dateFormatType = Arrays.stream(DateFormatType.values())
                .filter(d -> d.getDateFormat() == optionDataFormatTypeMenu)
                .findFirst();
        System.out.println("\nYour result is:");
        sortedDates.stream().map(d -> d.toString(dateFormatType.get())).forEach(System.out::println);

        dates.clear();
    }
}
