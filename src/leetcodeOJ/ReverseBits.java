package leetcodeOJ;

/**
 * Created by Flyln on 16/8/1.
 * 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * “>>>”运算符所作的是无符号的位移处理
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
    }

    // you need treat n as an unsigned value
    private int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;

            if (i < 31) { //最后一位
                res <<= 1;
            }
        }
        return res;
    }
}
