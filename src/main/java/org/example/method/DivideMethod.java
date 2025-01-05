package org.example.method;

import org.example.resource.OperationInterface;

public class DivideMethod<T extends Number> implements OperationInterface<T> {

    @Override
    public T Event(T firstNumber, T secondNumber) {
        if (firstNumber instanceof Integer && secondNumber instanceof Integer) {
            if (secondNumber.intValue() == 0) {
                throw new ArithmeticException("0은 허용할 수 없습니다.");
            }
            Integer result = firstNumber.intValue() / secondNumber.intValue();
            return (T) result;
        } else if (firstNumber instanceof Double && secondNumber instanceof Double) {
            if (secondNumber.doubleValue() == 0.0) {
                throw new ArithmeticException("0은 허용할 수 없습니다.");
            }
            Double result = firstNumber.doubleValue() / secondNumber.doubleValue();
            return (T) result;
        } else {
            throw new IllegalArgumentException("Unsupported types for division: " +
                    firstNumber.getClass() + " and " + secondNumber.getClass());
        }
    }
}
