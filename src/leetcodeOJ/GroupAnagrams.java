package leetcodeOJ;

import java.util.*;

/**
 * Created by Flyln on 16/8/9.
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * Map的get方法返回的类型是其Value的类型
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> maps = new HashMap<String,List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();


        for (String s : strs) {
            char[] ss = s.toCharArray();
            Arrays.sort(ss);

            String sort = new String(ss);

            if (maps.containsKey(sort)) {
                maps.get(sort).add(s);
            }

            else {
                List<String> s2 = new ArrayList<String>();
                s2.add(s);
                maps.put(sort, s2);
                result.add(s2);
            }
        }
        return result;
    }
}
