package com.development.task1.entity;

public abstract class CustomNumber {
    private NumberType type;

    public NumberType getType() {
        return type;
    }

    public void setType(NumberType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomNumber that = (CustomNumber) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        Class<?> currentClass = this.getClass();
        return currentClass.getSimpleName() + "{" +
                "type=" + type +
                '}';
    }
}
