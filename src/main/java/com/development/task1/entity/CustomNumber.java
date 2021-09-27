package com.development.task1.entity;

public class CustomNumber {
    private int value;

    public CustomNumber() {

    }

    public CustomNumber(int value) {
        this.value = value;
    }

    public CustomNumber(String value) {
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomNumber that = (CustomNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + value;
        return result;
    }

    @Override
    public String toString() {
        Class<?> currentClass = this.getClass();
        return currentClass.getSimpleName() + "{" +
                "value=" + value +
                '}';
    }
}
