package calculator;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> resultHistory = new ArrayList<>(); // 연산 결과를 저장
    
    /**
     * 사칙연산자를 이용해 계산하는 함수
     *
     * @param operator  사칙연산(+,-,*,/) 기호
     * @param firstNum  첫번째 값
     * @param secondNum 두번째 값
     * @return 입력받은 기호에 따라 계산된 결과 출력
     */
    public int calculate(char operator, int firstNum, int secondNum) {
        int result = 0;
        try {
            switch (operator){
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-' :
                    result = firstNum - secondNum;
                    break;
                case '*' :
                    result = firstNum * secondNum;
                    break;
                case '/' :
                    result = firstNum / secondNum;
                    break;
                default :// 정의되지 않은 기호의 경우 처리
                    System.out.println("정의되어있는 사칙 연산 기호가 아닙니다.");
                    break;
            }
        } catch (ArithmeticException e) { // 예외적인 산술조건이 발생했을 때 throw 됩니다. https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ArithmeticException.html
            System.out.println(e.getMessage()); // getMessage()는 throwable의 세부 정보 메시지 문자열을 반환합니다.
        }
        return result;
    }
    
    /**
     * resultHistory 변수에 간접 접근
     * 
     * @return resultHistory 반환
     * */
    public ArrayList<Integer> getResultHistory(){
        return resultHistory;
    }

    /**
     * resultHistory 간접적으로 접근하여 수정
     *
     * @param result 연산 결과값
     * */
    public void addResultHistory( int result ){
        resultHistory.add(result);
    }
}
