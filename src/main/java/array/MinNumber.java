package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumber {

  public String minNumber1(int[] nums) {
    List<String> strList = new ArrayList<>();
    for (int num : nums) {
      strList.add(String.valueOf(num));
    }
    strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
    StringBuilder sb = new StringBuilder();
    for (String str : strList) {
      sb.append(str);
    }
    return sb.toString();
    //        Arrays.asList()

  }

  public String minNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return "";
    }
    int n = nums.length;
    String[] numStr = new String[n];
    ;
    for (int i = 0; i < n; i++) {
      numStr[i] = nums[i] + "";
    }
    Arrays.sort(numStr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
    String ret = "";
    for (String str : numStr) {
      ret += str;
    }
    return ret;
  }
}
