package leetcodeOJ;

/**
 * Created by Flyln on 16/7/27.
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 找出一个字符数组中元素最长的相同前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix result = new LongestCommonPrefix();
        String[] strs = {"aa","a","abc","des"};
        System.out.println(result.longestCommon(strs));
    }

    private int minlen(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        return min;
    }

    public String longestCommon(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder res = new StringBuilder();
        int index = 0;
        int len = minlen(strs);

        while (index < len) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != strs[0].charAt(index))
                    return res.toString();
            }
            res.append(strs[0].charAt(index));
            index ++;
        }
        return res.toString();
    }
}
