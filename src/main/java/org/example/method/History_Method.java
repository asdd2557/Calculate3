package org.example.method;

import java.util.ArrayList;
import java.util.List;

public class History_Method {
   private final List<List<Object>> histories = new ArrayList<>();
    public List<Object> getHistory_To_int(int number){
        return histories.get(number);
    }
    public List<List<Object>> getHistories(){
        return this.histories;
    }

}
