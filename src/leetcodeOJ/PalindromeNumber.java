package leetcodeOJ;

/**
 * Created by Flyln on 16/8/8.
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 每次提取头尾两个数，判断它们是否相等，判断后去掉头尾两个数。
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121));
    }

    private boolean isPalindrome(int x) {
        if (x < 0) return false;

        int len = 1;

        while (x / len > 10) {
            len *= 10;
        }

        while (x > 0) {
            int left = x / len;
            int right = x % 10;

            if (left != right)
                return false;
            else {
                x = (x % len) / 10;
                len /= 100;
            }
        }
        return true;
    }
}
