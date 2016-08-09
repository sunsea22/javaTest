package leetcodeOJ.addTwoNumbers;

/**
 * Created by Flyln on 16/8/8.
 * 125. Valid Palindrome
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("Aa"));
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                res.append(s.charAt(i));
            }
        }

        String tmp = res.toString().toLowerCase();

        int left = 0;
        int right = tmp.length() - 1;

        while (left < right) {
            if (tmp.charAt(left) != tmp.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}
