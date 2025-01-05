package org.example.method;

import org.example.resource.OperationInterface;

public class PlusMethod<T extends Number> implements OperationInterface<T> {

    @Override
    public T Event(T firstNumber, T secondNumber) {
        if (firstNumber instanceof Integer && secondNumber instanceof Integer) {
            Integer result = firstNumber.intValue() + secondNumber.intValue();
            return (T) result;
        } else if (firstNumber instanceof Double && secondNumber instanceof Double) {
            Double result = firstNumber.doubleValue() + secondNumber.doubleValue();
            return (T) result;
        } else {
            throw new IllegalArgumentException("Unsupported types: " +
                    firstNumber.getClass() + " and " + secondNumber.getClass());
        }
    }
}
