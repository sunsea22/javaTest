package finalTest;

/**
 * Created by Flyln on 16/3/21.
 */
public class finalBuffer {
    public static void main(String[] args) {
        MyClass1 myClass = new MyClass1();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }
}

class MyClass1 {
    void changeValue(StringBuffer buffer) {
        buffer.append("word");
    }
}
