package ua.alevel.firstlevel.trianglearea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleAreaByThreePoints {
    public static void findTriangleAreaByThreePoints() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        float x1, y1;
        float x2, y2;
        float x3, y3;

        try {
            System.out.println("Enter x1 and y1");
            x1 = Float.parseFloat(bufferedReader.readLine());
            y1 = Float.parseFloat(bufferedReader.readLine());

            System.out.println("Enter x2 and y2");
            x2 = Float.parseFloat(bufferedReader.readLine());
            y2 = Float.parseFloat(bufferedReader.readLine());

            System.out.println("Enter x3 and y3");
            x3 = Float.parseFloat(bufferedReader.readLine());
            y3 = Float.parseFloat(bufferedReader.readLine());
            float area = ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
            System.out.println("area = " + area);
        } catch (NumberFormatException e) {
            System.out.println("error = " + e);
        }
    }
}
