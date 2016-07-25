package leetcodeOJ;


/**
 * Created by Flyln on 16/7/25.
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * 从末尾一次对应相加
 * 直接可以转成int（注意：要先减去一个'0'）
 * 方法String.valueOf()
 */
public class AddBinary {
    public static void main(String args[]) {
        String a = "11";
        String b = "1";
        AddBinary result = new AddBinary();
        System.out.println(result.addBinary(a, b));

    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int flag = 0;
        String result = "";

        while (pb >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + flag;
            result = String.valueOf(sum % 2) + result;
            flag = sum / 2;
            pa --;
            pb --;
        }

        while (pa >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + flag;
            result = String.valueOf(sum % 2) + result;
            flag = sum / 2;
            pa --;
        }

        if (flag == 1) {
            result = "1" + result;
        }
        return result;
    }
}
