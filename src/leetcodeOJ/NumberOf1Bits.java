package leetcodeOJ;

/**
 * Created by Flyln on 16/8/1.
 * 191. Number of 1 Bits
 * 一个无符号整数用2进制表示，其中1的个数
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(22));
    }

    private int hammingWeight(int n) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            res = n & 1;
            n >>>= 1;

            if (res == 1) count++;
        }
        return count;
    }

}
