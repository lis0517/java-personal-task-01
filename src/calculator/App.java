package calculator;

import java.util.Scanner;

public class App {

    /**
     * 문자열을 파싱하여 숫자 객체로 반환하는 메서드.
     *
     * @param input 파싱할 문자열
     * @return 파싱된 숫자 객체 (Double 또는 Integer)
     * @throws IllegalArgumentException 입력 문자열이 null이거나 빈 문자열인 경우
     * @throws NumberFormatException    변환이 실패한 경우
     * @see String#trim()
     */
    public static Number parseNumber(String input){
        if ( input == null || input.isEmpty() ){
            throw new IllegalArgumentException("숫자를 입력하지않았습니다.");
        }
        input = input.trim(); // 앞,뒤 문자열 공백 제거

        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException intError){
            try {
                return Long.parseLong(input);
            }catch (NumberFormatException longError){
                try{
                    return Double.parseDouble(input);
                }
                catch (NumberFormatException doubleError){
                    return null;
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in);

        do {
            /* 사칙연산을 진행할지 원의 너비를 구할지 선택 */
            System.out.print("1. 사칙연산 | 2. 원의 넓이 계산");
            int choice = sc.nextInt();

            if ( choice == 1 ){ // 사칙연산

                System.out.print("첫 번째 숫자를 입력하세요: ");
                Number firstNum = parseNumber(sc.next()); // 정수형 변수를 선언, nextInt로 입력받음

                System.out.print("두 번째 숫자를 입력하세요: ");
                Number secondNum = parseNumber(sc.next());

                System.out.print("사칙연산 기호를 입력하세요 : "); // +, -, *, /

                /* charAt() 함수는 문자열에서 특정 인덱스에 위치하는 단일문자를 반환합니다.
                 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html */
                char operator = sc.next().charAt(0);

                OperatorType operatorType = OperatorType.fromSymbol(operator);

                if ( operatorType == OperatorType.None ){
                    System.out.println("정의되지않은 기호입니다.");
                    continue;
                }

                Number result = arithmeticCalculator.calculate(operatorType, firstNum, secondNum);
                System.out.println("결과: " + result);

                arithmeticCalculator.addResultHistory(result);

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력)");
                String removeCode = sc.next().toLowerCase(); // toLowerCase() 함수는 기본 Locale 규칙을 사용하여 이 문자의 모든 문자를 소문자로 변환합니다.
                if ( removeCode.equals("remove") ){
                    arithmeticCalculator.removeResult();
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiryCode = sc.next().toLowerCase();
                if ( inquiryCode.equals("inquiry") ){
                    arithmeticCalculator.inquiryResults();
                }

                System.out.println("입력받은 값보다 큰 값들을 출력하시겠습니까? (lambda 입력 시 조회)");
                String findCode = sc.next().toLowerCase();
                if ( findCode.equals("lambda")){
                    System.out.print("기준 값을 입력하세요: ");
                    double threshold = sc.nextDouble();
                    arithmeticCalculator.findResultsGreaterThan( threshold );
                }
            }
            else{ // 원의 넓이
                System.out.print("반지름을 입력하세요: ");
                double radius = sc.nextDouble();
                /* 원의 넓이를 구하는 경우 반지름을 입력받아 원의 넓이를 구한 후 출력*/
                double area = circleCalculator.calculateCircleArea(radius);
                System.out.println("결과: " + area);
                /* 원의 넓이 저장 */
                circleCalculator.addResultHistory(area);
                /* 저장된 원의 넓이 값들 바로 전체 조회 */
                circleCalculator.inquiryResults();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");


        }while(!sc.next().toLowerCase().equals("exit"));
        sc.close();
    }
}
