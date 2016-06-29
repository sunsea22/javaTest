package interfaceApp;

/**
 * Created by Flyln on 16/6/12.
 */
public class InterfaceAppDemo {
    public static void main(String[] args){
        Person p = new Person("小白");
        p.setIsay(new BeforePerson());
        p.say();
        p.setIsay(new AfterPerson());
        p.say();
    }
}

//抽象出一个接口
interface Isay{
    public void say();
}

class BeforePerson implements Isay {
    public void say() {
        System.out.println("爷们");
    }
}

class AfterPerson implements Isay {
    public void say() {
        System.out.println("宫女");
    }
}

class Person {
    private String  name;

    private Isay isay;//把接口作为类中的一个属性

    public void setIsay(Isay isay) {
        this.isay = isay;
    }
    public Person(String name) {
        this.name = name;
    }

    //这个方法的实现是会变化的
    public void say() {
        isay.say();
    }
}



/*
class BeforePerson extends Person {
    public person(String name) {
        super(name);
    }
    public void say() {
        System.out.println("爷们");
    }
}

class AfterPerson extends Person {
    public person(String name) {
        super(name);
    }
    public void say() {
        System.out.println("宫女");
    }
}
*/
