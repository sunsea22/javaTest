package SynchronizedDemo;

/**
 * Created by Flyln on 16/6/29.
 * 通过对公共对象加锁
 */
class Foo2 extends Thread {
    private int val;
    private static Object lock = new Object();
    public Foo2(int v) {
        val = v;
    }
    public void printVal(int v) {
        synchronized (lock) {
            while (true)
                System.out.println(v);
        }
    }
    public void run() {
        printVal(val);
    }
}
public class SyncTest2 {
    public static void main(String args[]) {
        Foo2 f1 = new Foo2(1);
        f1.start();
        Foo2 f2 = new Foo2(3);
        f2.start();
    }
}
