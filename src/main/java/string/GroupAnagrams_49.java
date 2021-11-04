package string;

import java.util.*;

/**
 * @ClassName: GroupAnagrams_49 @Description: todo @Author Yuqi Du @Date 2021/10/31 10:53
 * 上午 @Version 1.0
 */
public class GroupAnagrams_49 {

  // 方法1 排序
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] cur = strs[i].toCharArray();
      Arrays.sort(cur);
      String cur1 = new String(cur);
      ArrayList<String> arr = map.getOrDefault(cur1, new ArrayList<>());
      arr.add(strs[i]);
      map.put(cur1, arr);

      //        java中数组对象的toString方法没有被重写，仍然是Object中的方法。
    }
    for (List<String> list : map.values()) {
      res.add(list);
    }
    return res;
  }

  // 简洁版
  public List<List<String>> groupAnagrams1(String[] strs) {
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      String key = String.valueOf(chars);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(strs[i]);
    }
    return new ArrayList<>(map.values()); // map.values会用一个collection把value包起来
  }

  // 方法二：计数
  public List<List<String>> groupAnagrams3(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      int[] counts = new int[26];
      int length = str.length();
      for (int i = 0; i < length; i++) {
        counts[str.charAt(i) - 'a']++;
      }
      // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < 26; i++) {
        if (counts[i] != 0) {
          sb.append((char) ('a' + i));
          sb.append(counts[i]);
        }
      }
      String key = sb.toString();
      List<String> list = map.getOrDefault(key, new ArrayList<String>());
      list.add(str);
      map.put(key, list);
    }
    return new ArrayList<List<String>>(map.values());
  }
}
