package ua.alevel;

public class MathSetImpl implements MathSet {

    private int size;

    public int getCapacity() {
        return capacity;
    }

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
        for (int i = 0, thisIndex = 0; i < numbers.length; i++) {
            if (isContains(numbers[i])) {
                continue;
            }
            this.numbers[thisIndex] = numbers[i];
            thisIndex++;
            size++;
        }
    }

    public MathSetImpl(Number[]... numbers) {
        int elemCount = 0;
        for (Number[] number : numbers) {
            elemCount += number.length;
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
        for (MathSet set : mathSet) {
            elemCount = set.getSize();
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
        add(new Number[]{n});
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
        join(new MathSet[]{ms});
    }

    @Override
    public void join(MathSet... ms) {
        int elemCount = 0;

        Number[] numbersDuplicate = getDuplicate();

        for (int i = 0; i < ms.length; i++) {
            elemCount += ms[i].getSize();
        }

        capacity += elemCount + CAPACITY_STEP;
        numbers = new Number[capacity];
        System.arraycopy(numbersDuplicate, 0, numbers, 0, size);

        for (int i = 0, index = size; i < ms.length; i++) {
            for (int j = 0; j < ms[i].getSize(); j++) {
                if (isContains(ms[i].get(j))) {
                    continue;
                }
                this.numbers[index] = ms[i].get(j);
                index++;
                size++;
            }
        }
    }

    @Override
    public void intersection(MathSet ms) {
        intersection(new MathSet[]{ms});
    }

    @Override
    public void intersection(MathSet... ms) {
        Number[] intersectionResult = new Number[this.getSize()];

        int size = 0;

        for (int i = 0, index = 0; i < this.size; i++) {
            boolean isAllContain = true;
            for (int j = 0; j < ms.length; j++) {
                if (!ms[j].isContains(this.get(i))) {
                    isAllContain = false;
                    break;
                }
            }
            if (isAllContain) {
                intersectionResult[index] = this.get(i);
                index++;
                size++;
            }
        }

        capacity = intersectionResult.length + CAPACITY_STEP;
        numbers = new Number[capacity];
        System.arraycopy(intersectionResult, 0, numbers, 0, size);
        this.size = size;
    }

    @Override
    public boolean isContains(Number number) {
        for (int i = 0; i < size; i++) {
            Number value = numbers[i];
            if (value.equals(number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Number get(int index) {
        return numbers[index];
    }

    @Override
    public Number getMax() {
        return getMinOrMax(false);
    }

    @Override
    public Number getMin() {
        return getMinOrMax(true);
    }

    private Number getMinOrMax(boolean isGetMin) {
        Number minOrMax = numbers[0];
        for (int i = 1; i < size; i++) {
            boolean isMinOrMax = isGetMin ? (numbers[i].doubleValue() < minOrMax.doubleValue())
                    : (numbers[i].doubleValue() > minOrMax.doubleValue());
            if (isMinOrMax) {
                minOrMax = numbers[i];
            }
        }
        return minOrMax;
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
        sort(numbersDuplicate, 0, size - 1, true);
        int medianIndex = size / 2;

        if (size % 2 == 0) {
            return (numbersDuplicate[medianIndex].doubleValue() + numbersDuplicate[medianIndex - 1].doubleValue()) / 2;
        } else {
            return numbersDuplicate[medianIndex];
        }
    }

    @Override
    public void sortAsc() {
        sort(numbers, 0, size - 1, true);
    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {
        sort(numbers, firstIndex, lastIndex, true);
    }

    @Override
    public void sortAsc(Number value) {
        for (int i = 0; i < size; i++) {
            if (numbers[i].equals(value)) {
                sort(numbers, i, size - 1, true);
                break;
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void sortDesc() {
        sort(numbers, 0, size - 1, false);
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {
        sort(numbers, firstIndex, lastIndex, false);
    }

    @Override
    public void sortDesc(Number value) {
        for (int i = 0; i < size; i++) {
            if (numbers[i].equals(value)) {
                sort(numbers, i, size - 1, false);
                break;
            }
        }
    }

    private void sort(Number[] numbers, int firstIndex, int lastIndex, boolean isAsc) {

        try {
            for (int i = lastIndex; i >= firstIndex; i--) {
                for (int j = firstIndex; j < i; j++) {
                    boolean hasToSwap = isAsc ? (numbers[j].doubleValue() > numbers[j + 1].doubleValue())
                            : (numbers[j].doubleValue() < numbers[j + 1].doubleValue());
                    if (hasToSwap) {
                        Number temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("wrong index");
        }
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
        Number[] numbers = new Number[lastIndex - firstIndex + 1];
        System.arraycopy(this.numbers, firstIndex, numbers, 0, lastIndex - firstIndex + 1);

        return new MathSetImpl(numbers);
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
            stringBuilder.append(numbers[i]).append(i != size - 1 ? ", " : "");
        }
        return stringBuilder.append("]").toString();
    }
}
