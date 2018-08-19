package examples.boot.firstweb;

public class Hello1 {
    public Hello1(){
        System.out.println(getClass().getName());
    }
    public static void main(String[] args){
        Hello1 h = new Hello1();
    }
}
