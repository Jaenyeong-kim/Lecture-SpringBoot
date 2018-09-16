package examples.boot.jpaexam.test;

// B라는 사용자
public class ExceptionTest01 {
    public static void main(String[] args) {
        Calc calc = new Calc();
        try {
            int value = calc.divide(10, 0);
            System.out.println(value);
        } catch (MyException ex) {
            System.out.println("0으로 나눌 수 없다.");
        }
    }
}
