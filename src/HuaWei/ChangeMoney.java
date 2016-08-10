package HuaWei;

import java.util.Scanner;

/**
 * Created by Flyln on 16/8/10.
 * 找零钱
 * 我们知道人民币有1、2、5、10、20、50、100这几种面值。现在给你n(1≤n≤250)元，让你计算换成用上面这些面额表示且总数不超过100张，共有几种。比如4元，能用4张1元、2张1元和1张2元、2张2元，三种表示方法。
 * 输入：输入有多组，每组一行，为一个整合n。输入以0结束。
 * 输出：输出该面额有几种表示方法。
 */
public class ChangeMoney {
    static int[] num = {1,2,5,10,20,50,100};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int input = scan.nextInt();
            if (input == 0) return;
            if (getNumber(input) > 0) {
                System.out.println(getNumber(input));
            }
        }
    }

    public static int getNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        int index = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            if (n >= num[i]) {
                index = i;
                break;
            }
        }
        return getChange(n,index);
    }

    public static int getChange(int n, int index) {
        if (n == 0 || n == 1 || index == 0) {
            return 1;
        }
        if (n < 0 || index < 0) {
            return 0;
        }
        return getChange(n-num[index],index) + getChange(n, index - 1);
    }
}
