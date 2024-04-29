package calculator;

/**
 * 연산자의 추상 클래스
 *
 * 이 클래스는 연산자의 기본 구조를 정의하고, 하위 클래스에서 구체적인 연산을 구현하도록 합니다.
 * 이를 통해 개방-폐쇄 원칙(OCP)을 준수하여 새로운 연산자를 쉽게 추가할 수 있습니다.
 */
public abstract class AbstractOperator {

    /**
     * 두 개의 정수를 받아 연산을 수행하는 추상 메서드
     *
     * @param firstNum 첫 번째 피연산자
     * @param secondNum 두 번째 피연산자
     * @return 연산 결과
     */
    public abstract <T extends Number> Number operate(T firstNum, T secondNum);

    /**
     *  피연산자들이 유효한지 확인
     * */
    public <T extends Number> boolean invalidNumber(T firstNum, T secondNum){
        return firstNum == null || secondNum == null;
    }
}
