package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> resultHistory = new ArrayList<>(); // 무한하게 저장하도록 추가

        while(true)
        {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt(); // 정수형 변수를 선언, nextInt로 입력받음

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : "); // +, -, *, /

            /* charAt() 함수는 문자열에서 특정 인덱스에 위치하는 단일문자를 반환합니다.
             * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html */
            char operator = sc.next().charAt(0);

            int result = 0;
            switch(operator){ // switch 문을 사용해 기호에 맞는 연산 실행
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    if ( secondNumber == 0 ) { // 분모가 0인 경우 예외처리
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    result = firstNumber / secondNumber;
                    break;
                default: // 정의되지 않은 기호의 경우 처리
                    System.out.println("정의되어있는 사칙 연산 기호가 아닙니다.");
                    break;
            }
            System.out.println("결과: " + result);

            resultHistory.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력)");
            String removeCode = sc.next().toLowerCase();
            if ( removeCode.equals("remove") ){
                resultHistory.remove(0);
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
