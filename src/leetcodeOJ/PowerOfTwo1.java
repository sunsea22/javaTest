package leetcodeOJ;

/**
 * Created by Flyln on 16/8/1.
 * leetcode 231: Power of Two
 * 如果是power of two, 则2进制表达中,有且仅有一个1.
 * 可以通过移位来数1的个数, 这里用了一个巧妙的办法, 即判断   N & (N-1) 是否为0.
 */
public class PowerOfTwo1 {
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo1().isPowerOfTwo1(44));
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
