package org.example.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scanner_Method {
    Scanner scanner = new Scanner(System.in);
    public List<Object> operation_Scanner(Number result){
        System.out.println("리설트는: "+ result);
        List<Object> list = new ArrayList<>();
        if(result == null){
            System.out.print("첫 번째 숫자를 입력하여주세요: ");
            list.add(scanner.nextInt());
            scanner.nextLine();
        }else{
            list.add(result.intValue());
        }
        System.out.print("연산자를 입력하여 주세요: ");
        list.add(scanner.nextLine());
        System.out.print("두 번째 숫자를 입력하여 주세요: ");
        list.add(scanner.nextInt());
        scanner.nextLine();
        System.out.println("int, double 중 type을 선택해 주세요.(d/i)");
        list.add(scanner.nextLine());
        if(list.get(3).equals("d") && list.get(0) instanceof Integer){
            list.set(0, ((Integer) list.get(0)).doubleValue());
            list.set(2, ((Integer) list.get(2)).doubleValue());
        }
        return list;
    }


    public List<Object> history_Scanner(List<List<Object>> histories) {
        int count = 0;
        System.out.println("계산 기록을 불러올까요? y/n");
        if (scanner.nextLine().equals("y")) {
            System.out.println("몇번째 기록을 불러올까요?");
            System.out.println("--History--");
            for (List<Object> history : histories) {
                count++;
                System.out.println(count + ". " + history.get(0) + " " + history.get(1) + " " + history.get(2) + " = " + history.get(4)+" type: "+history.get(3));
            }
            return histories.get(scanner.nextInt()-1);
        }
        return null;
    }

}
