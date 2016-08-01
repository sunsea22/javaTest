package leetcodeOJ;

/**
 * Created by Flyln on 16/8/1.
 * 7. Reverse Integer
 * 精简代码
 */
public class ReverseInteger1 {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger1().reverse1(123));
    }

    public int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res = res*10 + x%10;
            x = x/10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }
        return (int) res;
    }
}
