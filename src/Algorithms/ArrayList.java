package Algorithms;

import java.security.DrbgParameters;

public class ArrayList implements StringList {

    private static final int standardValue = 12;

    private String[] elements;

    private int SIZE;

    public ArrayList() {
        this.elements = new String[standardValue];
        this.SIZE = 0;
    }

    public ArrayList(int containsCapacity) {
        if (containsCapacity < 0) {
            throw new IllegalArgumentException("Содержимое емкости не может быть отрицательной.");
        }
        this.elements = new String[containsCapacity];
        this.SIZE = 0;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть 0.");
        }
        increaseCapacity(SIZE + 1);
        elements[SIZE] = item;
        SIZE++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new IndexOutOfBoundsException("Значение индекса находится за пределами допустимых значений.");
        }
        if (item == null) {
            throw new RuntimeException("Элемент не может быть 0.");
        }
        increaseCapacity(SIZE + 1);
        shiftArrayToTheRight(index);
        elements[index] = item;
        SIZE++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= SIZE) {
            throw new IndexOutOfBoundsException("Значение индекса находится за пределами допустимых значений.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть 0.");
        }
        String replacedItem = elements[index];
        elements[index] = item;
        return replacedItem;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть 0.");
        }
        for (int i = 0; i < SIZE; i++) {
            if (elements[i].equals(item)) {
                String removedItem = elements[i];
                shiftArrayToTheLeft(i);
                SIZE--;
                return removedItem;
            }
        }
        throw new IllegalArgumentException("Элемента нету в списке.");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= SIZE) {
            throw new IndexOutOfBoundsException("Значение индекса находится за пределами допустимых значений.");
        }
        String removedItem = elements[index];
        shiftArrayToTheLeft(index);
        SIZE--;
        return removedItem;

    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть 0.");
        }
        for (int i = 0; i < SIZE; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть 0.");
        }
        for (int i = 0; i < SIZE; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть 0.");
        }
        for (int i = SIZE - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= SIZE) {
            throw new IndexOutOfBoundsException("Значение индекса находится за пределами допустимых значений.");
        }
        return elements[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Элемент не может быть 0.");
        }
        if (this == otherList) {
            return true;
        }
        if (SIZE != otherList.size()) {
            return false;
        }
        for (int i = 0; i < SIZE; i++) {
            if (!elements[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean isEmpty() {
        return SIZE == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            elements[i] = null;
        }
        SIZE = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[SIZE];
        System.arraycopy(elements, 0, array, 0, SIZE);
        return array;
    }

    private void increaseCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, capacity);
            String[] newElements = new String[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, SIZE);
            elements = newElements;
        }
    }

        private void shiftArrayToTheRight (int index) // сдвигаем массив вправо
        {
            for (int i = SIZE; i > index; i--) {
                elements[i] = elements[i - 1];
            }
        }

        private void shiftArrayToTheLeft (int index) // сдвигаем массив влево
        {
            for (int i = index; i < SIZE - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[SIZE - 1] = null;
        }
    }

