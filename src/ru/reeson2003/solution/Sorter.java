package ru.reeson2003.solution;

import java.util.*;

/**
 * Created by reeson on 03.04.17.
 */
public class Sorter {
    private List<List<MyEntry>> entries;

    public Sorter() {
        entries = new ArrayList<>();
    }

    public void add(MyEntry myEntry) {
        boolean added = false;
        for (List<MyEntry> en: entries) {
            if (en.contains(myEntry)) {
                en.add(myEntry);
                added = true;
                break;
            }
        }
        if (!added) {
            List<MyEntry> list = new ArrayList<>();
            list.add(myEntry);
            entries.add(list);
        }
    }

    public void sort() {
        Collections.sort(entries, (o1, o2) -> o1.size() - o2.size());
    }
}
