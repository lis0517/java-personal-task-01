package calculator;

public class CircleCalculator extends Calculator {

    /** 원의 넓이를 구하는 함수
     *
     * @param radius 원의 반지름
     * @return 원의 넓이(double)
     * */
    public double calculateCircleArea(double radius){
        return radius * radius * Math.PI;
    }
}
