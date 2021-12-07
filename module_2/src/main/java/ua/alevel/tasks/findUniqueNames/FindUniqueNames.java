package ua.alevel.tasks.findUniqueNames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindUniqueNames {

    private final List<String> names = new ArrayList<>();
    private Reader reader;

    public FindUniqueNames(){
        readNamesFromFile();
    }

    private void readNamesFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("files/name_input.txt"));
            while (bufferedReader.ready()) {
                names.add(bufferedReader.readLine());
            }
            System.out.println("names = " + names);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findFirstUniqueName() {
        for (int i = 0; i < names.size(); i++) {
            int j;
            for (j = 0; j < names.size(); j++)
                if (i != j && names.get(i).equals(names.get(j))){
                    break;
                }
            if (j == names.size())
                return names.get(i);
        }
        return null;
    }
}
