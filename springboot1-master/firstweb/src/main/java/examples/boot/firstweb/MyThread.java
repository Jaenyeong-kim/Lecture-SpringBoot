package examples.boot.firstweb;

public class MyThread extends Thread{
    private MyData myData;
    private int flag;

    public MyThread(MyData myData, int flag){
        this.myData = myData;
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            if (flag == 1) {
                myData.print1();
            } else if(flag == 2){
                myData.print2();
            } else if(flag == 3){
                myData.print3();
            }
        }catch(Exception ex){

        }
    }

    public static void main(String[] args){
        MyData myData = new MyData();
        MyThread t1 = new MyThread(myData, 1);
        MyThread t2 = new MyThread(myData, 2);
        MyThread t3 = new MyThread(myData, 3);
        t1.start();
        t2.start();
        t3.start();
    }
}
