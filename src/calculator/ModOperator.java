package calculator;

public class ModOperator extends AbstractOperator {

    /** 나머지 계산
     * @param firstNum 첫 번째 값
     * @param secondNum 두 번째 값
     * @return firstNum과 secondNum에서 몫을 제외한 나머지를 반환
     */
    @Override
    public int operate(int firstNum, int secondNum) {
        return firstNum % secondNum;
    }
}
