package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNum = sc.nextInt(); // 정수형 변수를 선언, nextInt로 입력받음

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNum = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : "); // +, -, *, /

            /* charAt() 함수는 문자열에서 특정 인덱스에 위치하는 단일문자를 반환합니다.
             * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html */
            char operator = sc.next().charAt(0);

            int result = calculator.calculate(operator, firstNum, secondNum);
            System.out.println("결과: " + result);

            calculator.addResultHistory(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력)");
            String removeCode = sc.next().toLowerCase();
            if ( removeCode.equals("remove") ){
                calculator.removeResult();
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiryCode = sc.next().toLowerCase();
            if ( inquiryCode.equals("inquiry") ){
                calculator.inquiryResults();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

            /* toLowerCase() 함수는 기본 Locale 규칙을 사용하여 이 문자의 모든 문자를 소문자로 변환합니다.
             * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html */
            String exitCode = sc.next().toLowerCase(); // Exit, eXit 등 exit만 일치하면 작동하도록

            if ( exitCode.equals("exit") )
                break;
        }
        sc.close();
    }
}
