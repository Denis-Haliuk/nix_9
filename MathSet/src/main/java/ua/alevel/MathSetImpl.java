package ua.alevel;

public class MathSetImpl implements MathSet {

    private int size;
    private int capacity;
    private static final int CAPACITY_STEP = 10;

    private Number[] numbers;

    public MathSetImpl() {
        capacity = 10;
        numbers = new Number[capacity];
        size = 0;
    }

    public MathSetImpl(int capacity) {
        this.capacity = capacity;
        numbers = new Number[capacity];
        size = 0;
    }

    public MathSetImpl(Number[] numbers) {
        capacity = numbers.length + CAPACITY_STEP;
        this.numbers = new Number[capacity];
        for (int i = 0; i < numbers.length; i++) {
            if (isContains(numbers[i])) {
                continue;
            }
            this.numbers[i] = numbers[i];
            size++;
        }
    }

    public MathSetImpl(Number[]... numbers) {
        int elemCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            elemCount += numbers[i].length;
        }

        capacity = elemCount + CAPACITY_STEP;
        this.numbers = new Number[capacity];
        for (int i = 0, index = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (isContains(numbers[i][j])) {
                    continue;
                }
                this.numbers[index] = numbers[i][j];
                index++;
                size++;
            }
        }
    }

    public MathSetImpl(MathSet mathSet) {
        size = mathSet.getSize();
        capacity = size + CAPACITY_STEP;
        numbers = new Number[capacity];

        for (int i = 0; i < mathSet.getSize(); i++) {
            numbers[i] = mathSet.get(i);
        }
    }

    public MathSetImpl(MathSet... mathSet) {
        int elemCount = 0;
        for (int i = 0; i < mathSet.length; i++) {
            elemCount = mathSet[i].getSize();
        }

        capacity = elemCount + CAPACITY_STEP;
        this.numbers = new Number[capacity];
        for (int i = 0, index = 0; i < mathSet.length; i++) {
            for (int j = 0; j < mathSet[i].getSize(); j++) {
                if (isContains(mathSet[i].get(j))) {
                    continue;
                }
                this.numbers[index] = mathSet[i].get(j);
                index++;
                size++;
            }
        }
    }

    @Override
    public void add(Number n) {
        if (isContains(n)) return;

        int indexOfLast = size - 1;
        grow();
        numbers[indexOfLast + 1] = n;
        size++;
    }

    @Override
    public void add(Number... n) {
        Number[] numbersDuplicate = getDuplicate();
        capacity += n.length + CAPACITY_STEP;

        numbers = new Number[capacity];

        System.arraycopy(numbersDuplicate, 0, numbers, 0, size);

        for (int i = 0, index = size; i < n.length; i++) {
            if (isContains(n[i])) {
                continue;
            }
            this.numbers[index] = n[i];
            index++;
            size++;
        }
    }

    @Override
    public void join(MathSet ms) {
        Number[] numbersDuplicate = getDuplicate();
        capacity += ms.getSize() + CAPACITY_STEP;

        numbers = new Number[capacity];
        System.arraycopy(numbersDuplicate, 0, numbers, 0, size);

        for (int i = 0, index = size; i < ms.getSize(); i++) {
            if (isContains(ms.get(i))) {
                continue;
            }
            this.numbers[index] = ms.get(i);
            index++;
            size++;
        }
    }

    @Override
    public void join(MathSet... ms) {

    }

    @Override
    public void intersection(MathSet ms) {

    }

    @Override
    public void intersection(MathSet... ms) {

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

    @Override
    public Number get(int index) {
        return numbers[index];
    }

    @Override
    public Number getMax() {
        Number max = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i].doubleValue() > max.doubleValue()) {
                max = numbers[i];
            }
        }
        return max;
    }

    @Override
    public Number getMin() {
        Number min = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i].doubleValue() < min.doubleValue()) {
                min = numbers[i];
            }
        }
        return min;
    }

    @Override
    public Number getAverage() {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum / size;
    }

    @Override
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

    @Override
    public void sortAsc() {
        sortAsc(numbers);
    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {

    }

    @Override
    public void sortAsc(Number value) {

    }

    @Override
    public int getSize() {
        return size;
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

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {

    }

    @Override
    public void sortDesc(Number value) {

    }

    @Override
    public Number[] toArray() {
        return numbers;
    }

    @Override
    public Number[] toArray(int firstIndex, int lastIndex) {
        Number[] numbersDuplicate = new Number[lastIndex - firstIndex];
        System.arraycopy(numbers, firstIndex, numbersDuplicate, 0, lastIndex - firstIndex);
        return numbersDuplicate;
    }

    @Override
    public MathSet cut(int firstIndex, int lastIndex) {
        return null;
    }

    @Override
    public void clear() {
        capacity = CAPACITY_STEP;
        numbers = new Number[capacity];
        size = 0;
    }

    @Override
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


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(numbers[i]).append(i != size - 1 ? ", " : "]");
        }
        return stringBuilder.toString();
    }
}
