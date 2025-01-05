package org.example.controller;

import org.example.method.*;
import org.example.resource.OperationInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationController {

    private final Map<String, OperationInterface> calculrateInterfaceMap = new HashMap<>();

    public void addOperation() {
        DivideMethod<Double> divideMethodDouble = new DivideMethod<>();
        MultiplyMethod<Double> multiplyMethodDouble = new MultiplyMethod<>();
        MinusMethod<Double> minusMethodDouble = new MinusMethod<>();
        PlusMethod<Double> plusMethodDouble = new PlusMethod<>();

        calculrateInterfaceMap.put("/", divideMethodDouble);
        calculrateInterfaceMap.put("*", multiplyMethodDouble);
        calculrateInterfaceMap.put("-", minusMethodDouble);
        calculrateInterfaceMap.put("+", plusMethodDouble);
    }

    public List<Object> scanner_Start(Number result){
        ScannerMethod scannerMethod = new ScannerMethod();
        return scannerMethod.operationScanner(result);
    }

    public <T extends Number> T calculate_Start(T firstNumber, String operator, T secondNumber) {
        OperationInterface<T> operationInterface = (OperationInterface<T>) calculrateInterfaceMap.get(operator);
        if (operationInterface == null) {
            throw new UnsupportedOperationException("인터페이스가 Null입니다.");
        }
        return (T) operationInterface.Event(firstNumber, secondNumber);
    }
}
