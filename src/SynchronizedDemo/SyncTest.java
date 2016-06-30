package SynchronizedDemo;

/**
 * Created by Flyln on 16/6/29.
 * 如果你的类中有一个同步方法，这个方法可以被两个不同的线程同时执行，只要每个线程自己创建一个的该类的实例即可。
 *
 * 产生的输出是1和3交叉的,程序运行的结果证明两个线程都在并发的执行printVal方法
 */
class Foo extends Thread {
    private int val;
    public Foo(int v) {
        val = v;
    }

    public synchronized void printVal(int v) {
        while (true)
            System.out.println(v);
    }

    public void run() {
        printVal(val);
    }
}

public class SyncTest {
    public static void main(String args[]) {
        Foo f1 = new Foo(1);
        f1.start();
        Foo f2 = new Foo(3);
        f2.start();
    }
}
