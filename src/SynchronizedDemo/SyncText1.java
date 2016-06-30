package SynchronizedDemo;

/**
 * Created by Flyln on 16/6/29.
 * 实现真正的断面，同步了一个全局对象或者对类进行同步
 *
 * 下面的类不在对别的类实例同步而是对类进行同步。
 * 对于类Foo1而言，它只有唯一的类定义，两个线程在相同的锁上同步，因此只有一个线程可以执行printVal方法
 */
class Foo1 extends Thread {
    private int val;
    public Foo1(int v) {
        val = v;
    }
    public void printVal(int v) {
        synchronized (Foo1.class) {
            while (true)
                System.out.println(v);
        }
    }
    public void run() {
        printVal(val);
    }
}
public class SyncText1 {
    public static void main(String args[]) {
        Foo1 f1 = new Foo1(1);
        f1.start();
        Foo1 f2 = new Foo1(3);
        f2.start();
    }
}
