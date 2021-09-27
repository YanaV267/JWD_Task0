package com.development.task1.entity;

public class CustomDoubleNumber extends CustomNumber{
    private double value;

    public CustomDoubleNumber() {

    }

    public CustomDoubleNumber(double value) {
        this.value = value;
    }

    public CustomDoubleNumber(String value) {
        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomDoubleNumber that = (CustomDoubleNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) (result * 31 + value);
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
