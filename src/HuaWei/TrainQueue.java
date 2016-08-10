package HuaWei;

import java.util.Scanner;

/**
 * Created by Flyln on 16/8/10.
 * 火车进站问题
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。
 * 输入:有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 * 输出以字典序排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行
 *
 *
 */
public class TrainQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()) {
            count = scanner.nextInt();
            int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = scanner.nextInt();
            }

            for (int k = 0; k < count - 1; k++) {
                System.out.print(nums[k] + " ");
            }
            System.out.print(nums[count-1]);
            System.out.println();
            printZidDianXu(nums, count);
        }

    }

    public static boolean judge(int a[], int n) {
        //从头开始，判断其后比他小的元素是否为降序，若不是，则不是正确的出栈顺序，若遇到比他大的数，则把它当做标记
        int tag = a[0];
        int p = a[0];
        int i = 1;
        for (i = 1; i < n; i++) {
            if (a[i] > tag) {
                tag = a[i];
                p = tag;
            }
            else if (a[i] < p) {
                p = a[i];
            }
            else {
                break;
            }
        }

        if (i == n) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int[] reverse(int[] a, int l, int r) {
        int t;
        while (l < r) {
            t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
        return a;
    }

    public static void printZidDianXu(int[] a, int n) {
        int p = 0;
        int temp;
        while (true) {
            int flag = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i - 1 < 0)
                    break;
                if (a[i] > a[i - 1]) {
                    p = i - 1;
                    while (i < n && a[p] < a[i]) {
                        i++;
                    }

                    int minmax = i < n ? i - 1 : n - 1;
                    temp = a[minmax];
                    a[minmax] = a[p];
                    a[p] = temp;
                    a = reverse(a, p+1, n-1);
                    if (judge(a, n)) {
                        for (int k = 0; k < n - 1; k++) {
                            System.out.print(a[k] + " ");
                        }
                        System.out.print(a[n-1]);
                        System.out.println();
                    }
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }
}


