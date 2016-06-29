package abstractClass;

import java.util.Random;

/**
 * 抽象类的应用
 */
public class AbstractAppDemo {
    public static void main(String[] args) {
        LingjiuPalace lp = new Shemale("小白");
        System.out.println("小白应聘");
        lp.action();
    }
}


abstract class LingjiuPalace {
    //招聘活动
    public void action() {
        if (competition()) {
            System.out.println("恭喜你");
        }
        else {
            System.out.println("Sorry");
        }
    }

    //比赛方法
    public abstract boolean competition();
}

class Shemale extends LingjiuPalace {
    private String name;
    public Shemale(String name) {
        this.name = name;
    }
    public boolean competition() {
        System.out.println("我是"+name);
        System.out.println("比赛开始");
        Random r = new Random();
        return r.nextBoolean();
    }
}