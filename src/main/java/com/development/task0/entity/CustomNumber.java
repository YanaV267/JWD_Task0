package com.development.task0.entity;

public class CustomNumber {
    private double value;

    public CustomNumber() {

    }

    public CustomNumber(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomNumber that = (CustomNumber) o;
        return that.value == value;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
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
