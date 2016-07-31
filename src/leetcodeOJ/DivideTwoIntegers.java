package leetcodeOJ;

/**
 * Created by Flyln on 16/7/31.
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 *
 * 把除数表示为：dividend = 2^i * divisor + 2^(i-1) * divisor + ... + 2^0 * divisor。
 * 这样一来，我们所求的商就是各系数之和了，而每个系数都可以通过移位操作获得
 *
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(88,4));
    }

    private int divide(int dividend, int divisor) {
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        long quotient = dividePositive(absDividend,absDivisor);

        if (flag && quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return flag ? (int) quotient: -(int) quotient;

    }

    private long dividePositive(long dividend, long divisor) {
        if (dividend < divisor) return 0;

        long quotient = 1;
        long originalDivisor = divisor;
        while (dividend >= (divisor << 1)) {
            quotient <<= 1;
            divisor <<= 1;
        }
        return quotient + dividePositive(dividend - divisor, originalDivisor);
    }
}
