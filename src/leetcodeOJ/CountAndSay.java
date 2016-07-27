package leetcodeOJ;

/**
 * Created by Flyln on 16/7/27.
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth sequence.
 *
 *
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay result = new CountAndSay();
        System.out.println(result.countAndSay(6));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return 1 + "";
        }

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = say(result);
        }
        return result;
    }

    public String say(String s) {
        String result = "";
        int count = 0;
        char c = '0';
        for (int i = 0; i < s.length(); i ++) {
            c = s.charAt(i);
            if (count != 0) {
                if (s.charAt(i - 1) != c) {
                    result = result + count + s.charAt(i - 1);
                    count = 0;
                }
            }
            count ++;
        }
        result = result + count + c;
        return result;
    }

}
