package calculator;


/**
 * ArithmeticCalculator 클래스는 사칙연산을 수행하는 계산기 기능을 제공합니다.
 */
public class ArithmeticCalculator extends Calculator {

    /**
     * 사칙연산자를 이용해 계산하는 함수
     *
     * @param operatorType 사칙연산(+,-,*,/,%) 기호
     * @param firstNum     첫번째 피연산자
     * @param secondNum    두번째 피연산자
     * @return 계산 결과 (입력과 동일한 타입)
     * @throws ArithmeticException 예외적인 산술 조건이 발생했을 때 발생
     *                             (예: 0으로 나누기, 정수 오버플로우 등)
     * @see java.lang.ArithmeticException
     */
    public <T extends Number> Number calculate(OperatorType operatorType, T firstNum, T secondNum) {
        Number result = 0;
        AbstractOperator operator = null;

        try {
            switch (operatorType){
                case Add -> operator = new AddOperator();
                case Subtract -> operator = new SubtractOperator();
                case Multiply -> operator = new MultiplyOperator();
                case Divide -> operator = new DivideOperator();
                case Mod -> operator = new ModOperator();
            }
            if ( operator != null )
                result = operator.operate(firstNum, secondNum);

        } catch (ArithmeticException e) { // 예외적인 산술조건이 발생했을 때 throw 됩니다.
            System.out.println(e.getMessage()); // getMessage()는 throwable의 세부 정보 메시지 문자열을 반환합니다.
        }
        return result;
    }

    /**
     * 계산 결과 히스토리에서 첫번째 결과 값(가장 오래된 값)을 삭제하는 함수
     * resultHistory는 계산 결과를 저장하는 리스트 타입의 변수입니다.
     */
    public void removeResult(){
        resultHistory.remove(0);
    }

}
