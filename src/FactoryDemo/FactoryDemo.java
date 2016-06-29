package FactoryDemo;

/**
 * 工厂模式
 */
public class FactoryDemo {
    public static void main(String[] args) {
       /* ClothDoll cd = new ClothDoll();
        System.out.println(cd.getInfo());

        BarbieDoll bd = new BarbieDoll();
        System.out.println(bd.getInfo());*/

        Doll clothDoll = DollFactory.getInstance("cloth");
        if (clothDoll != null)
        System.out.println(clothDoll.getInfo());
    }
}

//工厂类
class DollFactory {
    public static Doll getInstance(String name) {
        if ("cloth".equals(name)) {
            return new ClothDoll();
        }
        else if ("barbie".equals(name)) {
            return new BarbieDoll();
        }
        return null;
    }
}


interface Doll {
    public String getInfo();
}

class ClothDoll implements Doll {
    public String getInfo() {
        return "我是布娃娃";
    }
}

class BarbieDoll implements Doll {
    public String getInfo() {
        return "芭比娃娃";
    }
}