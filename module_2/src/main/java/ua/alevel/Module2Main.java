package ua.alevel;

import ua.alevel.date.DateFormatter;

import java.util.ArrayList;
import java.util.List;

public class Module2Main {
    public static void main(String[] args) {
        System.out.println("Module2Main.main");
        DateFormatter dataFormatter = new DateFormatter();

        List<String> dateList = new ArrayList<String>();
        dateList.add("2020/12/05");
        dateList.add("05/04/2020");
        dateList.add("04-05-2020");
        dateList.add("024-05-2020");

        System.out.println("dateList = " + dateList);
        System.out.println("dateFormatter = " + dataFormatter.formattedDate(dateList));
    }
}
