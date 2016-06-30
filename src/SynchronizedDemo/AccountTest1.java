package SynchronizedDemo;

/**
 * Created by Flyln on 16/6/29.
 * 我们将deposit()和withdraw()方法进行同步，就能得到正确的结果了
 *
 *
 * Account中的getBalance()也访问了amount，为什么不对getBalance()同步呢？
 * 因为getBalance()并不会修改amount的值，所以，同时多个线程对它访问不会造成数据的混乱
 */
class Account1 {
    String name;
    float amount;

    public Account1(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public synchronized void deposit(float amt) {
        float tmp = amount;
        tmp += amt;

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {

        }
        amount = tmp;
    }

    public synchronized void withdraw(float amt) {
        float tmp = amount;
        tmp -= amt;

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {

        }
        amount = tmp;
    }
    public float getBalance() {
        return amount;
    }
}

public class AccountTest1 {
    private static int NUM_OF_THREAD = 1000;
    static Thread[] threads = new Thread[NUM_OF_THREAD];

    public static void main(String[] args){
        final Account1 acc = new Account1("John", 1000.0f);
        for (int i = 0; i< NUM_OF_THREAD; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    acc.deposit(100.0f);
                    acc.withdraw(100.0f);
                }
            });
            threads[i].start();
        }

        for (int i=0; i<NUM_OF_THREAD; i++){
            try {
                threads[i].join(); //等待所有线程运行结束
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
    }
}
