public class CreatThreat {
    public static void main(String[] args) {
        //继承Tread类实现
        MyThread t = new MyThread();
        t.start();
        //实现Runnable接口
        Runnable runner = new MyRunner();
        Thread t2 = new Thread(runner);
        t2.start();
        while(true){

        }
    }
}
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("in thread");
        while(true){

        }
    }
}


class MyRunner implements Runnable{
    @Override
    public void run(){
        System.out.println("in runnable");
        while(true){

        }
    }

}