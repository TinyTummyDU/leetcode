package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
  public char firstUniqChar(String s) {
    if (s.equals("")) return ' ';

    Map<String, Integer> hashTable = new HashMap<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (hashTable.get(String.valueOf(c)) == null) {
        hashTable.put(String.valueOf(c), 1);
      } else {
        Integer swap = hashTable.get(String.valueOf(c));
        hashTable.put(String.valueOf(c), swap + 1);
      }
    }
    for (char c : chars) {
      if (hashTable.get(String.valueOf(c)).equals(1)) {
        return c;
      }
    }
    return ' ';
  }

  // 时间复杂度 o（n） 空间o（26）= o（1）
  public char firstUniqChar1(String s) {
    HashMap<Character, Boolean> dic = new HashMap<>();
    char[] sc = s.toCharArray();
    for (char c : sc) dic.put(c, !dic.containsKey(c));
    for (char c : sc) if (dic.get(c)) return c;
    return ' ';
  }
}
