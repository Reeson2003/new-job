package ru.reeson2003.solution;

import java.io.*;
import java.util.Iterator;

/**
 * Created by reeson on 03.04.17.
 */
public class MyEntryReader implements Iterable<MyEntry> {
    private class MyEntryIterator implements Iterator<MyEntry> {
        private MyEntry next;
        public MyEntryIterator() throws IOException {
            next = nextEntry();
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public MyEntry next() {
            MyEntry result = next;
            try {
                next = nextEntry();
            } catch (IOException e) {
                next = null;
            }
            return result;
        }
    }
    private File file;
    private BufferedReader reader;
    private Iterator<MyEntry> iterator;

    public MyEntryReader(File file) throws IOException {
        this.file = file;
        reader = new BufferedReader(new FileReader(file));
        iterator = new MyEntryIterator();
    }

    private MyEntry nextEntry() throws IOException {
        String nextString = reader.readLine();
        if (nextString == null)
            return null;
        else {
            try {
                String first = nextString.substring(0, nextString.indexOf(Constants.DELIMETER));
                String second = nextString.substring(nextString.indexOf(Constants.DELIMETER) + 1,
                        nextString.lastIndexOf(Constants.DELIMETER));
                String third = nextString.substring(nextString.lastIndexOf(Constants.DELIMETER) + 1,
                        nextString.length());
                return new MyEntry(first, second, third);
            }catch (Exception e) {
                return null;
            }
        }
    }

    public void close() throws IOException {
        reader.close();
    }

    @Override
    public Iterator<MyEntry> iterator() {
        return iterator;
    }
}
