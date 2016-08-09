package leetcodeOJ;

/**
 * Created by Flyln on 16/8/9.
 * 96. Unique Binary Search Trees
 * 动态规划。找出递推公式
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
    }

    private int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;

        int res[] = new int[n+1];
        res[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j]*res[i-j-1];
            }
        }
        return res[n];
    }
}
