public class ThreadEx1 {
    public static void main(String[] args) {
        ThreadEX1_1 t1 = new ThreadEX1_1();
        Runnable r = new ThreadEX2_2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}
class ThreadEX1_1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.println(getName());
        }
    }
}

class ThreadEX2_2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}