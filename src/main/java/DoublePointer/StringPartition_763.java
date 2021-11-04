package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StringPartition @Description: todo @Author Yuqi Du @Date 2021/10/30 11:00 上午 @Version
 * 1.0
 */
public class StringPartition_763 {

  // You are given a string s. We want to partition the string into as many parts as possible so
  // that each letter appears in at most one part.
  //
  // Return a list of integers representing the size of these parts.

  // e.g
  //  Input: s = "ababcbacadefegdehijhklij"
  //  Output: [9,7,8]
  //  Explanation:
  //  The partition is "ababcbaca", "defegde", "hijhklij".
  //  This is a partition so that each letter appears in at most one part.
  //  A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less
  // parts.

  public List<Integer> partitionLabels(String s) {
    ArrayList<Integer> res = new ArrayList<>();

    int[] maxIndexForChar = new int[26];
    Arrays.fill(maxIndexForChar, -1);
    for (int i = 0; i < s.length(); i++) {
      maxIndexForChar[s.charAt(i) - 'a'] = i;
    }
    int curBound = 0;
    int start = 0;
    for (int r = 0; r < s.length(); r++) {
      curBound = Math.max(curBound, maxIndexForChar[s.charAt(r) - 'a']);
      if (r == curBound) {
        res.add(curBound - start + 1);
        start = curBound + 1;
      }
    }
    return res;
  }
}
