package org.example.method;

import java.util.ArrayList;
import java.util.List;

public class HistoryMethod {
   private final List<List<Object>> histories = new ArrayList<>();
    public List<Object> getHistoryToInt(int number){
        return histories.get(number);
    }
    public List<List<Object>> getHistories(){
        return this.histories;
    }

}
