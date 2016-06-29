package transferTuoFeng;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现字符串风格由驼峰形式转换成下划线形式
 * 首先，进行一遍遍历，记录下每个大写字母的位置，第一个大写字母除外；
 * 然后，将字符串转换成为字符数组，将对应位置上的字母前加上下划线；
 * 最后，将字符串数组进行拼接，大写字母位置的字符串替换成第二步中的字符串，完成。
 */
public class transform {
    public static String trans(String str) {

        List record = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if ((tmp <= 'Z') && (tmp >= 'A')) {
                record.add(i); //记录每个大写字母的位置
            }
        }
        record.remove(0); //第一个不需要加下划线

        str = str.toLowerCase(); //将字符串转换成小写
        char[] charOfStr = str.toCharArray();
        String[] t = new String[record.size()];
        for (int i = 0; i < record.size(); i++) {
            t[i] = "_" + charOfStr[(int)record.get(i)];
        }
        String result = "";
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((flag < record.size())&&(i == (int)record.get(flag))) {
                result += t[flag];
                flag++;
            }
            else result += charOfStr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        String hh = "HelloWorld";
        System.out.println(trans(hh));
    }
}
