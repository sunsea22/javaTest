package leetcodeOJ;

/**
 * Created by Flyln on 16/7/26.
 * 43. Multiply Strings
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * 在类对象中 equals()方法比较的是对象的值,==比较的是对象.即为对象的引用(即为内存地址)
 */
public class MutiplyStrings {
    public static void main(String[] args) {
        MutiplyStrings result = new MutiplyStrings();
        System.out.println(result.mutiply("88","0"));
    }

    public String mutiply(String num1, String num2) {
            if (num1.length() < num2.length()) {
                String tmp = num1;
                num1 = num2;
                num2 = tmp;
            }

            int lengthNum1 = num1.length() - 1;
            int lengthNum2 = num2.length() - 1;
            String result = "";
            String[] tmpArray = new String[lengthNum2 + 1];
            int flag = 0;

            String result1 = "";

            int k = 0;

            while (lengthNum2 >= 0) {
                for (int i = lengthNum1; i >= 0; i--) {
                    int multip = (int) (num1.charAt(i) - '0') * (int) (num2.charAt(lengthNum2) - '0') + flag;
                    result = String.valueOf(multip % 10) + result;
                    flag = multip / 10;
                }

                if (flag != 0) {
                    tmpArray[k] = String.valueOf(flag) + result;
                } else {
                    tmpArray[k] = result;
                }

                result = "";
                flag = 0;

                k++;
                lengthNum2--;
            }

            for (int i = 0; i < tmpArray.length; i++) {
                for (int j = 0; j < i; j++) {
                    tmpArray[i] = tmpArray[i] + "0";
                }
            }

            result1 = tmpArray[0];
            for (int i = 1; i < tmpArray.length; i++) {
                result1 = addTwoNum(result1, tmpArray[i]);
            }
            if (num1 == "0" || num2 == "0") return "0";
            else return result1;
    }

    private String addTwoNum(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int flag = 0;
        String result = "";

        while (pb >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + flag;
            result = String.valueOf(sum%10) + result;
            flag = sum / 10;
            pa --;
            pb --;
        }

        while (pa >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + flag;
            result = String.valueOf(sum%10) + result;
            flag = sum / 10;
            pa --;
        }
        if (flag != 0) {
            result = String.valueOf(flag) + result;
        }
        return result;
    }
}
