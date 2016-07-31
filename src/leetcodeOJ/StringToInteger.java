package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flyln on 16/7/31.
 * 8. String to Integer (atoi)
 * 一些非法字符串直接返回0，比如里面包含字母的，加减符号有多余的
 * 先将字符串两边的空格去除，函数trim()
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("9223372036854775809"));
    }

    private int myAtoi(String str) {

        if (str == null || str.length() == 0) return 0;

        str = str.trim();

        int i = 0;
        char flag = '+';

        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        }
        else if (str.charAt(0) == '+') {
            i++;
        }

        long res = 0;

        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = 10*res + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-') res = -res;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }
}
