package org.example.method;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScannerMethod {
    private final Scanner scanner = new Scanner(System.in);

    public List<Object> operationScanner(Number result) {
        System.out.println("리설트는: " + result);
        List<Object> list = new ArrayList<>();

        // 첫 번째 숫자 입력
        if (result == null) {
            System.out.print("첫 번째 숫자를 입력하여 주세요: ");
            list.add(scanner.nextInt());
            scanner.nextLine();
        } else {
            list.add(result.intValue());
        }

        // 연산자 입력
        System.out.print("연산자를 입력하여 주세요: ");
        list.add(scanner.nextLine());

        // 두 번째 숫자 입력
        System.out.print("두 번째 숫자를 입력하여 주세요: ");
        list.add(scanner.nextInt());
        scanner.nextLine();

        // 데이터 타입 선택
        System.out.println("int, double 중 type을 선택해 주세요.(d/i)");
        String type = scanner.nextLine();
        list.add(type);

        // 타입 변환 (람다 사용)
        if (type.equalsIgnoreCase("d")) {
            list = list.stream()
                    .map(obj -> (obj instanceof Integer) ? ((Integer) obj).doubleValue() : obj)
                    .collect(Collectors.toList());
        }

        return list;
    }

    public List<Object> historyScanner(List<List<Object>> histories) {
        // 계산 기록 선택
        System.out.println("계산 기록을 불러올까요? y/n");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("몇 번째 기록을 불러올까요?");
            System.out.println("--History--");

            // 히스토리를 열거 및 출력 (람다와 스트림 사용)
            IntStream.range(0, histories.size())
                    .mapToObj(i -> (i + 1) + ". " + formatHistory(histories.get(i)))
                    .forEach(System.out::println);

            // 선택된 기록 반환
            return histories.get(scanner.nextInt() - 1);
        }
        return null;
    }

    // 기록 형식화를 위한 메서드
    private String formatHistory(List<Object> history) {
        return String.format("%s %s %s = %s (type: %s)",
                history.get(0), history.get(1), history.get(2), history.get(4), history.get(3));
    }

    // 연산자 정의를 위한 Enum
    public enum Operator {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        // 문자열로부터 연산자 찾기
        public static Optional<Operator> fromSymbol(String symbol) {
            return Arrays.stream(values())
                    .filter(op -> op.symbol.equals(symbol))
                    .findFirst();
        }
    }
}
