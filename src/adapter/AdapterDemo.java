package adapter;

/**
 * Created by Flyln on 16/7/20.
 * 适配器模式
 */
public class AdapterDemo {
    public static void main(String[] args) {
        PowerA powerA = new PowerAImpl();
        start(powerA);

        PowerB powerB = new PowerBImpl();
        PowerAAdapter pa = new PowerAAdapter(powerB);
        start(pa);
    }

    //开始工作
    public static void start(PowerA powerA) {
        powerA.insert();
    }
}

class PowerAAdapter implements PowerA {
    private PowerB powerB;

    public PowerAAdapter(PowerB powerB) {
        this.powerB = powerB;
    }

    public void insert() {
        powerB.connect();
    }

}

/**
 * 电源A接口
 */
interface PowerA{
    public void insert();
}

class PowerAImpl implements PowerA {
    public void insert() {
        System.out.println("电源A插入，开始工作");
    }
}

/**
 * 电源B接口
 */
interface PowerB{
    public void connect();
}

class PowerBImpl implements PowerB {
    public void connect() {
        System.out.println("电源B已连接，开始工作");
    }
}
