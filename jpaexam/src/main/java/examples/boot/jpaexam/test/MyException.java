package examples.boot.jpaexam.test;

public class MyException extends RuntimeException{
    public MyException(String str){
        super(str);
    }

    public MyException(Exception ex){
        super(ex);
    }
}