package org.example.method;


import org.example.resource.Operation_Interface;

public class Minus_Method<T extends Number> implements Operation_Interface<T> {
    @Override
    public T Event(T first_Number, T second_Number) {
        if (first_Number instanceof Integer && second_Number instanceof Integer) {
            Integer result = first_Number.intValue() - second_Number.intValue();
            return (T) result;
        } else if (first_Number instanceof Double && second_Number instanceof Double) {
            Double result = first_Number.doubleValue() - second_Number.doubleValue();
            return (T) result;
        } else {
            throw new IllegalArgumentException("Unsupported types for multiplication: " +
                    first_Number.getClass() + " and " + second_Number.getClass());
        }
    }
}