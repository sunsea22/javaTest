package leetcodeOJ;

/**
 * Created by Flyln on 16/8/9.
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s
 * 通过一个长度为26的整形数组，对应英文中的26个字母a-z。从前向后循环字符串s和t，s中出现某一字母则在该字母在数组中对应的位置上加1，t中出现则减1。
 * 如果在s和t中所有字符都循环完毕后，整型数组中的所有元素都为0，则可认为s可由易位构词生成t
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("aaa","aaa"));
    }

    private boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;

        int[] letterCounter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letterCounter[s.charAt(i) - 'a']++;
            letterCounter[s.charAt(i) - 'a']--;
        }

        for (int count: letterCounter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
