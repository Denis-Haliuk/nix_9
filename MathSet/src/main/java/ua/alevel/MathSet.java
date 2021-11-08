package ua.alevel;

public interface MathSet {
    void add(Number n);
    void add(Number ... n);

    void join(MathSet ms);
    void join(MathSet ... ms);

    void intersection(MathSet ms);
    void intersection(MathSet ... ms);

    void sortDesc();
    void sortDesc(int firstIndex, int lastIndex);
    void sortDesc(Number value);

    void sortAsc();
    void sortAsc(int firstIndex, int lastIndex);
    void sortAsc(Number value);

    boolean isContains(Number number);

    int getSize();

    Number get(int index);
    Number getMax();
    Number getMin();
    Number getAverage();
    Number getMedian();

    Number[] toArray();
    Number[] toArray(int firstIndex, int lastIndex);
    MathSet cut(int firstIndex, int lastIndex);

    void clear();
    void clear(Number[] numbers);
}
