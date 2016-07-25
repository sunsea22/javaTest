package leetcodeOJ;

/**
 * Created by Flyln on 16/7/23.
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution result = new Solution();
        System.out.println(result.getSum(3,5));
    }
}

class Solution {
    public int getSum(int a, int b) {
        int result = a ^ b;
        int carray = (a & b) << 1;
        if (carray != 0) return getSum(result,carray);
        return result;
    }
}