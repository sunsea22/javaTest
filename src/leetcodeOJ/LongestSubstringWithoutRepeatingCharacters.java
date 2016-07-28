package leetcodeOJ;

import java.util.HashMap;

/**
 * Created by Flyln on 16/7/27.
 * 3. Longest Substring Without Repeating Characters
 *
 * 字符串的IndexOf()方法搜索在该字符串上是否出现了作为参数传递的字符串,如果找到字符串,则返回字符的起始位置
 * (0表示第一个字符,1表示第二个字符依此类推)如果说没有找到则返回 -1
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;

        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
