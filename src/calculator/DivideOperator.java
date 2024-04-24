package calculator;

public class DivideOperator extends AbstractOperator {

    /** 나누기 계산
     * @param firstNum 첫 번째 값
     * @param secondNum 두 번째 값
     * @return firstNum과 secondNum을 나눈 값
     */
    @Override
    public int operate(int firstNum, int secondNum) {
        return firstNum / secondNum;
    }

}
