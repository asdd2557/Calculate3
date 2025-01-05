package org.example.controller;

import org.example.method.HistoryMethod;
import org.example.method.ScannerMethod;

import java.util.List;

public class HistoryController {
    HistoryMethod historymethod = new HistoryMethod();
    public void addHistory(List<Object> history){
        historymethod.getHistories().add(history);
    }
    public List<Object> scanner_start(List<List<Object>> histories){
        ScannerMethod scannerMethod = new ScannerMethod();
      return  scannerMethod.historyScanner(histories);
    }

}
