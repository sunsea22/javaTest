package SynchronizedDemo;

/**
 * Created by Flyln on 16/6/29.
 * 在程序中我们使用了一个简化版本的Account类，代表了一个银行账户的信息。
 * 在主程序中我们首先生成了1000个线程，然后启动它们，每一个线程都对John的账户进行存100元，然后马上又取出100元。
 * 这样，对于John的账户来说，最终账户的余额应该是还是1000元才对。然而运行的结果却超出我们的想像
 * 每次运行的结果输出值都不一样
 *
 *
 * 这就是多线程中的同步的问题。在我们的程序中，Account中的amount会同时被多个线程所访问，
 * 这就是一个竞争资源，通常称作竞态条件。对于这样的多个线程共享的资源我们必须进行同步，以避免一个线程的改动被另一个线程所覆盖。
 * 在我们这个程序中，Account中的amount是一个竞态条件，所以所有对amount的修改访问都要进行同步
 */
class Account {
    String name;
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public void deposit(float amt) {
        float tmp = amount;
        tmp += amt;

        try {
            Thread.sleep(1); //模拟其它处理所需要的时间，比如刷新新数据库等
        } catch (InterruptedException e) {
            //Ignore
        }

        amount = tmp;
    }

    public void withdraw(float amt) {
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

public class AccountTest {
    private static int NUM_OF_THREAD = 1000;
    static Thread[] threads = new Thread[NUM_OF_THREAD];

    public static void main(String[] args) {
        final Account acc = new Account("john", 1000.0f);
        for (int i = 0; i < NUM_OF_THREAD; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    acc.deposit(100.0f);
                    acc.withdraw(100.0f);
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < NUM_OF_THREAD; i++) {
            try {
                threads[i].join(); //等待所有线程运行结束
            } catch (InterruptedException e) {

            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
    }
}
