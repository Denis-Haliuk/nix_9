package ua.alevel;

public class MathSet {

    private int size;
    private int capacity;
    private static final int CAPACITY_STEP = 10;

    private Number[] numbers;

    public MathSet() {
        capacity = 10;
        numbers = new Number[capacity];
        size = 0;
    }

    public MathSet(int capacity) {
        this.capacity = capacity;
        numbers = new Number[capacity];
        size = 0;
    }

    public void add(Number n) {
        if (isContains(n)) return;

        int indexOfLast = size - 1;
        grow();
        numbers[indexOfLast + 1] = n;
        size++;
    }

    private boolean isContains(Number number) {
        for (int i = 0; i < size; i++) {
            Number value = numbers[i];
            if (value.equals(number)) {
                return true;
            }
        }
        return false;
    }

    private void grow() {
        if (capacity - size <= 2) {
            Number[] numbersDuplicate = getDuplicate();
            numbers = new Number[capacity + CAPACITY_STEP];
            System.arraycopy(numbersDuplicate, 0, numbers, 0, capacity);
            capacity += CAPACITY_STEP;
        }
    }

    public Number get(int index) {
        return numbers[index];
    }

    public Number getMax() {
        Number max = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i].doubleValue() > max.doubleValue()) {
                max = numbers[i];
            }
        }
        return max;
    }

    public Number getMin() {
        Number min = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i].doubleValue() < min.doubleValue()) {
                min = numbers[i];
            }
        }
        return min;
    }

    public Number getAverage() {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum / size;
    }

    public Number getMedian() {
        Number[] numbersDuplicate = getDuplicate();
        sortAsc(numbersDuplicate);
        int medianIndex = size / 2;

        if (size % 2 == 0) {
            return (numbersDuplicate[medianIndex].doubleValue() + numbersDuplicate[medianIndex - 1].doubleValue()) / 2;
        } else {
            return numbersDuplicate[medianIndex];
        }
    }

    public void sortAsc() {
        sortAsc(numbers);
    }


    private void sortAsc(Number[] numbers) {
        for (int i = size - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j].doubleValue() > numbers[j + 1].doubleValue()) {
                    Number temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public void sortDesc() {
        for (int i = size - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j].doubleValue() < numbers[j + 1].doubleValue()) {
                    Number temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public Number[] toArray() {
        return numbers;
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        Number[] numbersDuplicate = new Number[lastIndex - firstIndex];
        System.arraycopy(numbers, firstIndex, numbersDuplicate, 0, lastIndex - firstIndex);
        return numbersDuplicate;
    }

    public void clear() {
        capacity = CAPACITY_STEP;
        numbers = new Number[capacity];
        size = 0;
    }

    public void clear(Number[] numbers) {
        int[] indexesForDelete = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            boolean isWrittenIndex = false;
            for (int j = 0; j < size; j++) {
                if (numbers[i].equals(this.numbers[j])) {
                    indexesForDelete[i] = j;
                    isWrittenIndex = true;
                    break;
                }
            }

            if (!isWrittenIndex) {
                indexesForDelete[i] = -1;
            }
        }

        Number[] numbersDuplicate = new Number[capacity];

        for (int i = 0, j = 0; i < size; i++) {
            boolean mustBeDeleted = false;
            for (int index : indexesForDelete) {
                if (index == i) {
                    mustBeDeleted = true;
                    break;
                }
            }

            if (!mustBeDeleted) {
                numbersDuplicate[j] = this.numbers[i];
                ++j;
            }
        }

        System.arraycopy(numbersDuplicate, 0, this.numbers, 0, capacity);
    }

    private Number[] getDuplicate() {
        Number[] numbersDuplicate = new Number[capacity];
        System.arraycopy(numbers, 0, numbersDuplicate, 0, capacity);
        return numbersDuplicate;
    }


    public void output() {
        System.out.println("numbers length= " + size);
        for (int i = 0; i < size; i++) {
            System.out.println("numbers = " + numbers[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(numbers[i]).append(i != size - 1 ? ", " : " ]");
        }
        return stringBuilder.toString();
    }
}
