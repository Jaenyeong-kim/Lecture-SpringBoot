package examples.boot.firstweb;

public class MyData {
    public synchronized  void print1() throws Exception{
        for(int i = 0; i < 5; i++){
            System.out.print("*");
            // Math.random() : 0.0 <= x < 1.0
            // * 1000        : 0.0 <- x < 1000.0
            Thread.sleep((long)(Math.random() * 1000));
        }
    }

    public synchronized void print2() throws Exception{
        for(int i = 0; i < 5; i++){
            System.out.print("#");
            // Math.random() : 0.0 <= x < 1.0
            // * 1000        : 0.0 <- x < 1000.0
            Thread.sleep((long)(Math.random() * 1000));
        }
    }

    public synchronized void print3() throws Exception{
        for(int i = 0; i < 5; i++){
            System.out.print("-");
            // Math.random() : 0.0 <= x < 1.0
            // * 1000        : 0.0 <- x < 1000.0
            Thread.sleep((long)(Math.random() * 1000));
        }
    }
}
