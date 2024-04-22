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

        System.out.println("operator = " + operator);
    }
}
