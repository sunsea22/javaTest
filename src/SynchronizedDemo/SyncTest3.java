package SynchronizedDemo;

/**
 * Created by Flyln on 16/6/29.
 * 同步粒度比2要小
 */
class Foo3 extends Thread {
    private String name;
    private String val;
    public Foo3(String name, String v) {
        this.name = name;
        val = v;
    }
    public void printVal() {
        synchronized (val) {
            while (true)
                System.out.println(name+val);
        }
    }
    public void run() {
        printVal();
    }
}
public class SyncTest3 {
    public static void main(String args[]) {
        Foo3 f1 = new Foo3("Foo 1:","printVal");
        f1.start();
        Foo3 f2 = new Foo3("Foo 2:", "printVal");
        f2.start();
    }
}
