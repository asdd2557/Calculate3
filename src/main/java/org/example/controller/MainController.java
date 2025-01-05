package org.example.controller;

import java.util.ArrayList;
import java.util.List;


public class MainController {
    public void start() {
        OperationController operationController = new OperationController();
        HistoryController historyController = new HistoryController();
        operationController.addOperation();
        List<Object> historyList = new ArrayList<>();
        historyList.add((Integer) null);
        historyList.add((Integer) null);
        historyList.add((Integer) null);
        historyList.add((Integer) null);
        historyList.add((Integer) null);
        while (true) {
            List<Object> operationList;
            //operationList에 저장 및 출력
            if (historyList == null) {
                operationList = (operationController.scanner_Start(null));
            } else {
                operationList = (operationController.scanner_Start((Number) historyList.get(4)));
            }

            //결과 operationList에 추가
            operationList.add(operationController.calculate_Start((Number) operationList.get(0), (String) operationList.get(1), (Number) operationList.get(2)));
            //결과 출력
            System.out.println("결과: " + operationList.get(4));
            //결과 포함 저장
            historyController.addHistory(operationList);
            //히스토리 출력
            historyList = historyController.scanner_start(historyController.historymethod.getHistories());


        }
    }
}
