
public class ThreadTest implements Runnable {

    private int balance;

    public static void main(String[] args) {
        ThreadTest threadJob = new ThreadTest();
        Thread thread1 = new Thread(threadJob);
        Thread thread2 = new Thread(threadJob);
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println("balance is: " + balance);
        }

    }

    public void increment() {
        System.out.println("11");
        System.out.println("22");
        synchronized(this) {
            int i = balance;
            balance = i + 1;
        }
        System.out.println("33");
        System.out.println("44");
    }
}

