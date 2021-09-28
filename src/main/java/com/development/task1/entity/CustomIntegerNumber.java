package com.development.task1.entity;

public class CustomIntegerNumber extends CustomNumber{
    private int value;

    public CustomIntegerNumber() {

    }

    public CustomIntegerNumber(int value) {
        this.value = value;
    }

    public CustomIntegerNumber(String value) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomIntegerNumber that = (CustomIntegerNumber) o;
        return that.value == value;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result * 31 + value;
        return result;
    }

    @Override
    public String toString() {
        Class<?> currentClass = this.getClass();
        return currentClass.getSimpleName() + "{" +
                "type=" + super.getType() +
                ", value=" + value +
                '}';
    }
}
