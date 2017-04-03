package ru.reeson2003.solution;

/**
 * Created by reeson on 03.04.17.
 */
public class MyEntry {
    private String first;
    private String second;
    private String third;

    public MyEntry(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MyEntry))
            return false;
        MyEntry another = (MyEntry) obj;
        return (!this.first.equals("") && another.first.equals(this.first)) ||
                (!this.second.equals("") && another.second.equals(this.second)) ||
                (!this.third.equals("") && another.third.equals(this.third));
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode() + third.hashCode();
    }

    @Override
    public String toString() {
        return first + Constants.DELIMETER + second + Constants.DELIMETER + third;
    }
}
