package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); // 정수형 변수를 선언, nextInt로 입력받음

        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요 : "); // +, -, *, /

        /* charAt() 함수는 문자열에서 특정 인덱스에 위치하는 단일문자를 반환합니다.
        * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html */
        char operator = sc.next().charAt(0);

        int result = 0;
        switch(operator){ // switch 문을 사용해 기호에 맞는 연산 실행
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if ( num2 == 0 ) { // 분모가 0인 경우 예외처리
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                result = num1 / num2;
                break;
            default: // 정의되지 않은 기호의 경우 처리
                System.out.println("정의되어있는 사칙 연산 기호가 아닙니다.");
                break;
        }
        System.out.println("결과: " + result);


    }
}
