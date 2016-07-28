package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flyln on 16/7/28.
 * 345. Reverse Vowels of a String
 * 会超时
 */
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        List record = new ArrayList();
        StringBuilder res = new StringBuilder();

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                record.add(i); //记录每个元音字母的位置
            }
        }

        for (int i = record.size() - 1; i >= 0; i --) {
            res.append(s.charAt((int) record.get(i)));
        }

        char[] charOfString = s.toCharArray();

        for (int i = 0; i < record.size(); i ++) {
            charOfString[(int)record.get(i)] = res.charAt(i);
        }

        for (int i = 0; i < charOfString.length; i++) result += charOfString[i];

        return result;
    }
}
