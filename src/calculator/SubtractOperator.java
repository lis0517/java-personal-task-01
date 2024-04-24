package calculator;

public class SubtractOperator extends AbstractOperator {
    /** 빼기 계산
     * @param firstNum 첫 번째 값
     * @param secondNum 두 번째 값
     * @return firstNum과 secondNum을 뺀 값
     */
    @Override
    public int operate(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}
