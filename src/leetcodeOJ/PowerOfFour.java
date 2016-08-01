package leetcodeOJ;

/**
 * Created by Flyln on 16/8/1.
 * 342. Power of Four
 * 一个数 num 如果是 4 的 N 次方必然也是 2 的 N 次方。
 * 所以可以先判断 num 是否是 2 的 N 次方。然后再将 2 的 N 次方中那些不是 4 的 N 次方的数去掉
 *
 * 4的次方数的最高位的1都是奇数位，那么我们只需与上一个数(0x55555555) <==> 1010101010101010101010101010101
 */
public class PowerOfFour {
    public static void main(String[] args) {

    }

    private boolean isPowerOfFour(int num) {
       return num > 0 && ((num & (num - 1)) == 0) && (num & 0x55555555) == num;
    }

    /**
     * 在确定其是2的次方数了之后，发现只要是4的次方数，减1之后可以被3整除
     * @param num
     * @return
     */
    private boolean isPowerOfFour1(int num) {
       return num > 0 && ((num & (num - 1)) == 0) && (num - 1) % 3 == 0;
    }
}
