package leetcodeOJ;

/**
 * Created by Flyln on 16/7/27.
 * size表示每次要处理的字符相隔的长度
 * j+size-2*i 表示中间元素的位置关系j+2*numRows-2i-2（i表示第几行，j当前处理的位置）
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion result = new ZigZagConversion();
        System.out.println(result.convert("0123456789",5));
    }

    public String convert(String a, int numRows) {
        if (a == null || numRows == 1) return a;

        if (numRows >= a.length()) return a;

        int len = a.length();

        StringBuffer res = new StringBuffer();
        int size = 2 * numRows - 2; //每次处理的长度

        for (int i = 0; i < numRows; i++) { //每一行的元素
            char ch;
            for (int j = i; j < len; j += size) {
                ch = a.charAt(j);
                res.append(ch);

                if (i != 0 && i != numRows - 1) { //如果是中间元素单独处理
                    int tmp = j + size - 2 * i;
                    if (tmp < len) {
                        ch = a.charAt(tmp);
                        res.append(ch);
                    }
                }
            }
        }
        return res.toString();
    }
}
