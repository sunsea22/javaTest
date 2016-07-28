package leetcodeOJ;

/**
 * Created by Flyln on 16/7/28.
 * 344. Reverse String
 * 如果直接把result定义为String类型，会出现超时
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("hello"));
    }

    public String reverseString(String s) {
        //String result = "";

        StringBuilder result = new StringBuilder();

        int len = s.length() - 1;

        while(len >= 0) {
            result.append(s.charAt(len));
            len --;
        }
        return result.toString();
    }
}
