package leetcodeOJ;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flyln on 16/7/31.
 * 350. Intersection of Two Arrays II
 *注意：List和Set的remove方法实现是不一样的
 * List的remove方法是根据索引来删除对象的
 * Set的remove方法是直接删除对象
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        System.out.println(new IntersectionOfTwoArrays().intersect(a,b));

    }

    private int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (list1.contains(nums2[i])) {
                res.add(nums2[i]);
                //list1.remove(nums2[i]);
                list1.remove(list1.indexOf(nums2[i]));
            }
        }

        int[] result = new int[res.size()];
        int count = 0;
        for (int num: res) {
            result[count++] = num;
        }
        return result;
    }
}
