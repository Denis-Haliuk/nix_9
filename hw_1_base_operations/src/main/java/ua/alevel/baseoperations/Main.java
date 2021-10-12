package ua.alevel.baseoperations;

import ua.alevel.baseoperations.firsttask.FirstTask;
import ua.alevel.baseoperations.secondtask.SecondTask;
import ua.alevel.baseoperations.thirdtask.ThirdTask;

public class Main {
    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask();
        firstTask.firstTask();

        SecondTask secondTask = new SecondTask();
        secondTask.secondTask();

        ThirdTask thirdTask = new ThirdTask();
        thirdTask.thirdTask();

    }
}
