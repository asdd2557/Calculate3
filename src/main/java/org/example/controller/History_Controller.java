package org.example.controller;

import org.example.method.History_Method;
import org.example.method.Scanner_Method;

import java.util.List;
import java.util.Scanner;

public class History_Controller {
    History_Method history_method = new History_Method();
    public void addHistory(List<Object> history){
        history_method.getHistories().add(history);
    }
    public List<Object> scanner_start(List<List<Object>> histories){
        Scanner_Method scanner_method = new Scanner_Method();
      return  scanner_method.history_Scanner(histories);
    }

}
