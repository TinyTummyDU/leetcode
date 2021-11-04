package general;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences {

  // 884

  public static void main(String[] args) {

    List<Integer> test = new LinkedList<>();
    test.add(1);
    test.add(2);
    Integer[] test1 = test.toArray(new Integer[4]);
    // toArray长度不够的话，会自动加长
    for (Integer i : test1) {
      System.out.println(i);
    }
  }

  public String[] uncommonFromSentences(String A, String B) {
    Map<String, Integer> map = new HashMap<>();
    for (String s1 : A.split(" ")) {
      // getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
      map.put(s1, map.getOrDefault(s1, 0) + 1);
    }
    for (String s2 : B.split(" ")) {
      // getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
      map.put(s2, map.getOrDefault(s2, 0) + 1);
    }
    List<String> ans = new LinkedList();
    for (String s3 : map.keySet()) {
      if (map.get(s3) == 1) {
        ans.add(s3);
      }
    }
    return ans.toArray(new String[ans.size()]);
  }
}
