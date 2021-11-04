package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUniqChar_jianzhi_50 {

  public char firstUniqChar(String s) {
    HashMap<Character, Boolean> dic = new HashMap<>();
    char[] sc = s.toCharArray();
    for (char c : sc) dic.put(c, !dic.containsKey(c));
    for (char c : sc) if (dic.get(c)) return c;
    return ' ';
  }

  public char firstUniqChar1(String s) {
    //        hashmap是无序存储，应该用LinkedHashMap
    HashMap<Character, Integer> dic = new HashMap<>();
    char[] sc = s.toCharArray();
    int count = 0;
    for (char c : sc) {
      if (dic.containsKey(c)) {
        dic.put(c, dic.get(c) + 1);
      } else {
        dic.put(c, 1);
      }
    }
    for (char c : sc) if (dic.get(c) == 1) return c;
    return ' ';
  }

  //    hashmap是无序存储，应该用LinkedHashMap
  //    当s很长时，方法二省去了遍历s的时间，妙啊,默认最多只出现元素两次
  public char firstUniqChar2(String s) {
    Map<Character, Boolean> dic = new LinkedHashMap<>();
    char[] sc = s.toCharArray();
    for (char c : sc) dic.put(c, !dic.containsKey(c));
    for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
      if (d.getValue()) return d.getKey();
    }
    return ' ';
  }
}
