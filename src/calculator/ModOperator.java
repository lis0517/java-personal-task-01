package calculator;

public class ModOperator extends AbstractOperator {

    /**
     * 두 피연산자의 나머지 연산을 수행합니다.
     *
     * @param firstNum 첫 번째 피연산자
     * @param secondNum 두 번째 피연산자
     * @return 두 피연산자의 나머지 (double 타입)
     */
    @Override
    public <T extends Number> Number operate(T  firstNum, T  secondNum) {
        if (invalidNumber(firstNum, secondNum)){
            throw new IllegalArgumentException("나머지 연산은 null 값이 아닌 경우에만 진행할 수있습니다.");
        }

        return firstNum.doubleValue() % secondNum.doubleValue();
    }
}
