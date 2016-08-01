package leetcodeOJ;

/**
 * Created by Flyln on 16/8/1.
 * 326. Power of Three
 * Given an integer, write a function to determine if it is a power of three.
 * 任何一个3的x次方一定能被int型里最大的3的x次方整除
 */
public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(324));
    }

    private boolean isPowerOfThree(int n) {
        return n > 0&&(1162261467%n == 0);
    }
}
