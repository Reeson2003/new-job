package ru.reeson2003.solution;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by reeson on 03.04.17.
 */
public class Programm {
    public static void main(String[] args) {
        File file = new File("lng.csv");
        try {
            MyEntryReader reader = new MyEntryReader(file);
            Iterator<MyEntry> iterator = reader.iterator();
            Sorter sorter = new Sorter();
            while (iterator.hasNext())
                sorter.add(iterator.next());
            reader.close();
        } catch (IOException e) {
            System.err.println("Can not read file");
            System.exit(1);
        }
    }
}
