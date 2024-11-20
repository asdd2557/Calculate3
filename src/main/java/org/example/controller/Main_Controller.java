package org.example.controller;

import org.example.method.History_Method;

import java.util.ArrayList;
import java.util.List;


public class Main_Controller {
    public void start() {
        Operation_Controller operationController = new Operation_Controller();
        History_Controller historyController = new History_Controller();
        operationController.addOperation();
        List<Object> history_list = new ArrayList<>();
        history_list.add((Integer) null);
        history_list.add((Integer) null);
        history_list.add((Integer) null);
        history_list.add((Integer) null);
        history_list.add((Integer) null);
        while (true) {
            List<Object> operation_List;
            //operation_List에 저장 및 출력
            if (history_list == null) {
                operation_List = (operationController.scanner_Start(null));
            } else {
                operation_List = (operationController.scanner_Start((Number) history_list.get(4)));
            }

            //결과 operation_List에 추가
            operation_List.add(operationController.calculate_Start((Number) operation_List.get(0), (String) operation_List.get(1), (Number) operation_List.get(2)));
            //결과 출력
            System.out.println("결과: " + operation_List.get(4));
            //결과 포함 저장
            historyController.addHistory(operation_List);
            //히스토리 출력
            history_list = historyController.scanner_start(historyController.history_method.getHistories());


        }
    }
}
