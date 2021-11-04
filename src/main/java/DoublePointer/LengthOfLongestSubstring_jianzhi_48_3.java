package DoublePointer;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_jianzhi_48_3 {

  //    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

  // 动态规划+哈希表
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> dic = new HashMap<>();
    int res = 0, tmp = 0;
    for (int j = 0; j < s.length(); j++) {
      int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
      dic.put(s.charAt(j), j); // 更新哈希表
      tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
      res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
    }
    return res;
  }

  //    动态规划 + 线性遍历
  public int lengthOfLongestSubstring1(String s) {
    int res = 0, tmp = 0;
    for (int j = 0; j < s.length(); j++) {
      int i = j - 1;
      while (i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
      tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
      res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
    }
    return res;
  }

  //    双指针 + 哈希表 (滑动窗口)
  // 记录每个字母出现的最后位置
  public int lengthOfLongestSubstring2(String s) {
    HashMap<Character, Integer> hashMap = new HashMap<>();
    int left = 0;
    int right = 0;
    int res = 0;
    while (right < s.length()) {
      char ch = s.charAt(right);
      // 当前值已经出现过了，更新左边界
      if (hashMap.containsKey(ch)) {
        // 另 left = 当前值最后一次出现的地方 + 1 ，使得[left,right]无重复值
        // 需要取较大值
        left = Math.max(left, hashMap.get(ch) + 1);
      }
      // 更新最后出现下标
      hashMap.put(ch, right);
      // [left,right]的长度
      res = Math.max(res, right - left + 1);
      right++;
    }
    return res;
  }
  //    left = Math.max(left, hashMap.get(ch) + 1);为什么取最大值
  //    因为需要保证的是[left,right]没有重复值。而你的left如果不取最大值的话，是有可能往前退，就无法保证这个条件了。
  //    比如abba , 到第二个a的时候，这时候上一轮的第二个b完成，此时left=2 ，而a上一次出现的地方是0。
  //    如果你直接left = hashMap.get(ch) + 1 ,此时 left = 1 ,范围为[left,right] = [1,3] 而此时[1,2] = bb ，b已经重复了。
  //    本质就是你这个字母上次出现的地方到当前再次出现的位置，这两者间可能存在重复的值

}
