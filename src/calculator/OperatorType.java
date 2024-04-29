package calculator;

/**
 * 사칙연산에 사용되는 연산자 타입을 나타내는 열거형
 *
 * 이렇게 제작한 이유 : App에 switch문을 사용해서 비교를 진행하는 코드가 계속 남아있다면
 * 하드코딩에 가깝게 코딩되어있는 상태로 생각했습니다. 'Enum으로 관리해라'라는 항목을 봤을 때 이것을 어떻게하면
 * 더 깔끔하게 사용할 수 있을까라는 고민을 계속 했고 이렇게 만들게되면 OperatorType이 아무리 늘어나도
 * App.java 파일에는 영향을 받지않겠다는 생각을 하게되었습니다.
 */
public enum OperatorType {
    /**
     * 연산자가 지정되지 않은 상태
     */
    None,
    /**
     * 덧셈 연산자 (+)
     */
    Add('+'),
    /**
     * 뺄셈 연산자 (-)
     */
    Subtract('-'),
    /**
     * 곱셈 연산자 (*)
     */
    Multiply('*'),
    /**
     * 나눗셈 연산자 (/)
     */
    Divide('/'),
    /**
     * 나머지 연산자 (%)
     */
    Mod('%');

    /**
     * 연산자를 나타내는 기호
     */
    private final char symbol;

    /**
     * 기본 생성자
     * 연산자 기호를 지정하지 않는 경우 사용
     */
    OperatorType(){
        this.symbol = '\0';
    }

    /**
     * 연산자 기호를 인자로 받는 생성자
     *
     * @param symbol 연산자 기호
     */
    OperatorType(char symbol){
        this.symbol = symbol;
    }

    /**
     * 주어진 연산자 기호에 해당하는 OperatorType을 반환하는 메서드
     *
     * @param symbol 연산자 기호
     * @return 주어진 연산자 기호에 해당하는 OperatorType
     *         주어진 연산자 기호에 해당하는 OperatorType이 없는 경우 None을 반환
     */
    public static OperatorType fromSymbol(char symbol){
        for( OperatorType operatorType : values()){
            if ( operatorType.symbol == symbol )
                return operatorType;
        }
        return None;
    }
}
