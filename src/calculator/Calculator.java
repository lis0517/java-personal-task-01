package calculator;

import java.util.ArrayList;

public abstract class Calculator {

    /* final 사용 이유.
     * 현재 작업 한 코드는 필드들이 초기화 이후에 변경되지 않을 것임을 암시하고 있습니다.
     * 이 의도를 더욱 명확하게 전달하기 위해 final 키워드를 사용했습니다. */
    protected final ArrayList<Number> resultHistory;

    public Calculator() { // 생성자
        resultHistory = new ArrayList<>(); // 인스턴스 생성 시점에 ArrayList 초기화
    }

    /** resultHistory 필드에 간접 접근(가져오기)
     *
     * @return resultHistory 반환
     * */
    public ArrayList<Number> getResultHistory(){
        return resultHistory;
    }

    /** resultHistory 필드에 간접 접근 (추가)
     *
     * @param result 연산 결과값
     * */
    public void addResultHistory( Number result ){
        resultHistory.add(result);
    }

    /** 저장된 연산 결과들을 조회하는 함수 */
    public void inquiryResults() {
        for (Number value : resultHistory) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}