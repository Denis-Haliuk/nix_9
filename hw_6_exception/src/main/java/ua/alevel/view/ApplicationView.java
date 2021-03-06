package ua.alevel.view;

import ua.alevel.controller.ChangeTimeInDateController;
import ua.alevel.controller.DifferenceBetweenDatesController;
import ua.alevel.controller.SortingDateController;
import ua.alevel.impl.MenuServiceImpl;

public class ApplicationView {
    private static final int MENU_CHOOSE_OPTION = 1;
    private MenuServiceImpl menu;
    private boolean flag;
    private DifferenceBetweenDatesController differenceBetweenDatesController;
    private ChangeTimeInDateController changeTimeInDateController;
    private SortingDateController sortingDateController;

    public ApplicationView() {
        this.menu = new MenuServiceImpl();
        this.flag = true;
        this.differenceBetweenDatesController = new DifferenceBetweenDatesController();
        this.changeTimeInDateController = new ChangeTimeInDateController();
        this.sortingDateController=new SortingDateController();
    }

    public void showApplicationView() {
        while (flag) {
            menu.mainMenu();
            int option = menu.chooseOption(MENU_CHOOSE_OPTION);
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    differenceBetweenDatesController.differenceBetweenDates();
                    break;
                case 2:
                    changeTimeInDateController.changeTime(1);
                    break;
                case 3:
                    changeTimeInDateController.changeTime(2);
                    break;
                case 4: sortingDateController.sortDate();
            }

        }
    }
}
