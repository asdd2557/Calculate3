package org.example.controller;

import org.example.method.*;
import org.example.resource.Operation_Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation_Controller {

    private final Map<String, Operation_Interface> calculrate_InterfaceMap = new HashMap<>();

    public void addOperation() {
        Divide_Method<Double> divide_method_double = new Divide_Method<>();
        Multiply_Method<Double> multiply_method_double = new Multiply_Method<>();
        Minus_Method<Double> minus_method_double = new Minus_Method<>();
        Plus_Method<Double> plus_method_double = new Plus_Method<>();

        calculrate_InterfaceMap.put("/", divide_method_double);
        calculrate_InterfaceMap.put("*", multiply_method_double);
        calculrate_InterfaceMap.put("-", minus_method_double);
        calculrate_InterfaceMap.put("+", plus_method_double);
    }

    public List<Object> scanner_Start(Number result){
        Scanner_Method scanner_method = new Scanner_Method();
        return scanner_method.operation_Scanner(result);
    }

    public <T extends Number> T calculate_Start(T first_Number, String operator, T second_Number) {
        Operation_Interface<T> operation_interface = (Operation_Interface<T>) calculrate_InterfaceMap.get(operator);
        if (operation_interface == null) {
            throw new UnsupportedOperationException("인터페이스가 Null입니다.");
        }
        return (T) operation_interface.Event(first_Number, second_Number);
    }
}
