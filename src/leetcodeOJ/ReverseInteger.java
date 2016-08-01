package leetcodeOJ;


/**
 * Created by Flyln on 16/8/1.
 * 7. Reverse Integer
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-123));
    }

    private int reverse(int x) {
        String tmp = "";
        double res = 0;
        if (x == 0) return 0;
        else if (x < 0) {
            tmp = intToString(-x);
            for (int i = 0; i < tmp.length(); i++) {
                res = Math.pow(10,tmp.length() - 1 - i)*(tmp.charAt(i) - '0') + res;
            }
            if (-res < -2147483648) return 0;
            else return -(int)res;
        }
        else {
            tmp = intToString(x);
            for (int i = 0; i < tmp.length(); i++) {
                res = Math.pow(10,tmp.length() - 1 - i)*(tmp.charAt(i) - '0') + res;
            }
            if (res > 2147483647) return 0;
            else return (int)res;
        }

    }

    private String intToString(int x) {
        StringBuilder res = new StringBuilder();
        while (x > 0) {
            res.append(x % 10);
            x = x / 10;
        }
        return res.toString();
    }
}
