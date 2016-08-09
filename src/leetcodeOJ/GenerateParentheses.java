package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flyln on 16/8/9.
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    private List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        String item = new String();

        if (n <= 0)
            return res;
        dfs(res,item,n,n);
        return res;
    }

    public void dfs(List<String> res, String item, int left, int right) {
        if (left > right)
            return;

        if (left == 0 && right == 0) {
            res.add(new String(item));
            return;
        }

        if (left > 0)
            dfs(res,item+'(',left-1,right);
        if (right > 0)
            dfs(res,item+')',left,right-1);
    }
}
