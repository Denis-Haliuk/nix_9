package ua.alevel.tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DateFormatter {

    private static final int MAX_DAY = 31;
    private static final int MAX_MONTH = 12;

    private static final String[] acceptedFormatList =
            {"^(\\d{4})/(\\d{2})/(\\d{2})$",
                    "^(\\d{2})/(\\d{2})/(\\d{4})$",
                    "^(\\d{2})-(\\d{2})-(\\d{4})$"
            };

    private final List<String> dateList = new ArrayList<>();

    private Reader reader;

    public DateFormatter(){
        readDatesFromFile();
    }

    private void readDatesFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("module_2/files/date_input.txt"));
            while (bufferedReader.ready()) {
                dateList.add(bufferedReader.readLine());
            }
            System.out.println("dates = " + dateList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<String> formattedDate() {
        List<String> formattedDate = new ArrayList<>();
        for (String s : dateList) {
            if (formatDate(s) != null) {
                formattedDate.add(formatDate(s));
            }
        }
        return formattedDate;
    }

    private String formatDate(String date) {
        String[] splittedDate;
        String formattedDate = null;
        StringBuilder builder = new StringBuilder();
        if (date.matches(acceptedFormatList[0])) {
            splittedDate = date.split("/");
            String year = splittedDate[0];
            String month = splittedDate[1];
            String day = splittedDate[2];
            if(Integer.parseInt(month) <= MAX_MONTH && Integer.parseInt(day) <= MAX_DAY) {
                formattedDate = builder.append(year).append(month).append(day).toString();
            }
        }

        if (date.matches(acceptedFormatList[1])) {
            splittedDate = date.split("/");
            String year = splittedDate[2];
            String month = splittedDate[1];
            String day = splittedDate[0];
            if(Integer.parseInt(month) <= MAX_MONTH && Integer.parseInt(day) <= MAX_DAY) {
                formattedDate = builder.append(year).append(month).append(day).toString();
            }
        }

        if (date.matches(acceptedFormatList[2])) {
            splittedDate = date.split("-");
            String year = splittedDate[2];
            String month = splittedDate[0];
            String day = splittedDate[1];
            if(Integer.parseInt(month) <= MAX_MONTH && Integer.parseInt(day) <= MAX_DAY) {
                formattedDate = builder.append(year).append(month).append(day).toString();
            }
        }
        return formattedDate;
    }
}
