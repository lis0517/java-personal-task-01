package calculator;

import java.util.ArrayList;

public class Calculator {

    /* final 사용 이유.
    * 현재 작업 한 코드는 필드들이 초기화 이후에 변경되지 않을 것임을 암시하고 있습니다.
    * 이 의도를 더욱 명확하게 전달하기 위해 final 키워드를 사용했습니다. */
    private final ArrayList<Integer> resultHistory; // 연산 결과를 저장
    private final ArrayList<Double> circleAreaResultHistory; // 원 연산 결과를 저장

    public Calculator() { // 생성자
        resultHistory = new ArrayList<>(); // 인스턴스 생성 시점에 ArrayList 초기화
        circleAreaResultHistory = new ArrayList<>();
    }

    //region arithmetic

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

    /** resultHistory 필드에 간접 접근(가져오기)
     *
     * @return resultHistory 반환
     * */
    public ArrayList<Integer> getResultHistory(){
        return resultHistory;
    }

    /** resultHistory 필드에 간접 접근 (추가)
     *
     * @param result 연산 결과값
     * */
    public void addResultHistory( int result ){
        resultHistory.add(result);
    }

    /** 첫번째 결과 값을 삭제하는 함수 */
    public void removeResult(){
        resultHistory.remove(0);
    }

    /** 저장된 연산 결과들을 조회하는 함수 */
    public void inquiryResults(){
        for( int value : resultHistory ){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //endregion

    //region area of circle
    
    /** 원의 넓이를 구하는 함수
     * 
     * @param radius 원의 반지름
     * @return 원의 넓이(double)
     * */
    public double calculateCircleArea(double radius){
        return radius * radius * Math.PI;
    }

    /** circleAreaResultHistory 필드에 간접 접근(가져오기)
     *  @return circleAreaResultHistory 반환
     * */
    public ArrayList<Double> getCircleAreaResultHistory(){
        return circleAreaResultHistory;
    }

    /** circleAreaResultHistory 필드에 간접 접근 (추가)
     *  @param result 연산 결과값
     * */
    public void addCircleAreaResultHistory(double result){
        circleAreaResultHistory.add(result);
    }

    /** 저장된 연산 결과들을 조회하는 함수 */
    public void inquiryCircleAreaResults(){
        for(double value : circleAreaResultHistory){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //endregion
}