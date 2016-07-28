package leetcodeOJ;

/**
 * Created by Flyln on 16/7/28.
 * 345. Reverse Vowels of a String
 * 类似于快速排序的思想
 */
public class ReverseVowelsOfString1 {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString1().reverseVowels1("leetcode"));
    }

    public String reverseVowels1(String s) {
        int i = 0;
        int j = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] c = s.toCharArray();

        while (i < j) {
            while (i < j && !vowels.contains(c[i] + "")) i ++;
            while (i < j && !vowels.contains(c[j] + "")) j --;

            if (i < j) {
                char tmp = c[i];
                c[i++] = c[j];
                c[j--] = tmp;
            }
        }
        return String.valueOf(c);
    }
}
