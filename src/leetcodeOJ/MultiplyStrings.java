package leetcodeOJ;

/**
 * Created by Flyln on 16/7/27.
 * [Leetcode 43]Multiply Strings
 * 方法二
 * 设置数组记录单个位置相乘的结果，最后负责相加进位
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings result = new MultiplyStrings();
        System.out.println(result.multiply("9133", "0"));
    }

    public String multiply(String num1, String num2) {
        int num1Length = num1.length();
        int num2Length = num2.length();
        int d1,d2;
        int carry = 0;
        int tmp;

        int[] calculate = new int[num1Length + num2Length];
        StringBuilder sb = new StringBuilder();

        for (int i = num1Length - 1; i >= 0; i --) {
            d1 = num1.charAt(i) - '0';

            for (int j = num2Length - 1; j >= 0; j--) {
                d2 = num2.charAt(j) - '0';

                calculate[i + j + 1] += d1 * d2;
            }
        }

        for (int i = calculate.length - 1; i >= 0; i --) {
            tmp = (calculate[i] + carry) % 10;
            carry = (calculate[i] + carry) / 10;
            calculate[i] = tmp;
        }

        for (int num: calculate) {
            sb.append(num);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
