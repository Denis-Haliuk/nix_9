package ua.alevel.date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateFormatter {

    int MAX_DAY = 31;
    int MAX_MONTH = 12;

    private final String[] acceptedFormatList =
            {"^(\\d{4})/(\\d{2})/(\\d{2})$",
                    "^(\\d{2})/(\\d{2})/(\\d{4})$",
                    "^(\\d{2})-(\\d{2})-(\\d{4})$"
            };

    public List<String> formattedDate(List<String> dateList) {
        List<String> formattedDate = new ArrayList<String>();
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
