package calculator;

public class ArithmeticCalculator extends Calculator {

    private AbstractOperator operator;


    /** 사칙연산자를 이용해 계산하는 함수
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
                case '+' -> this.operator = new AddOperator();
                case '-' -> this.operator = new SubtractOperator();
                case '*' -> this.operator = new MultiplyOperator();
                case '/' -> this.operator = new DivideOperator();
                case '%' -> this.operator = new ModOperator();
                default  -> System.out.println("정의되어있는 사칙 연산 기호가 아닙니다.");
            }
            if ( this.operator != null )
                result = this.operator.operate(firstNum, secondNum);

        } catch (ArithmeticException e) { // 예외적인 산술조건이 발생했을 때 throw 됩니다. https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ArithmeticException.html
            System.out.println(e.getMessage()); // getMessage()는 throwable의 세부 정보 메시지 문자열을 반환합니다.
        }
        return result;
    }

    /** 첫번째 결과 값을 삭제하는 함수 */
    public void removeResult(){
        resultHistory.remove(0);
    }

}
