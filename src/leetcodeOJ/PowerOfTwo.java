package leetcodeOJ;

/**
 * Created by Flyln on 16/8/1.
 * 231. Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 * 判断一个整数是不是2的次幂
 */
public class PowerOfTwo {
    public static void main(String[] args) {

    }
    
    private boolean isPowerOfTwo(int n) {
        int res = 0;
        int k = 0;

        if (n == Integer.MIN_VALUE) return false;

        for (int i = 0; i < 32; i++) {
            res = n & 1;
            n >>>= 1;

            if (res == 1) k++;
        }
        if (k == 1) return true;
        else return false;
    }
}
