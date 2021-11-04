package general;

public class SwapForLongestRepeatedCharacterSubstring {

  // 1156单字符重复子串的最大长度

  // https://leetcode-cn.com/problems/swap-for-longest-repeated-character-substring/solution/java-tong-ji-ge-zi-mu-chu-xian-ci-shu-zai-shun-xu-/
  public int maxRepOpt1(String text) {
    int len = text.length();
    int[] ch_count = new int[26];
    for (int i = 0; i < len; ++i) {
      ++ch_count[text.charAt(i) - 'a'];
    }
    char last_ch = text.charAt(0); // text的第一个字符
    int count = 1, res = 1;
    for (int i = 1; i < len; ++i) {
      if (last_ch != text.charAt(i)) { // "上一种字符"a和 当前字符b如果不等
        int temp_idx = i; //
        while (temp_idx + 1 < len && last_ch == text.charAt(temp_idx + 1)) {
          // 找到b后面的 a子串，注意必须aaabaaaa这种，中间只隔了一个b
          ++count;
          ++temp_idx;
        }
        if (ch_count[last_ch - 'a'] > count) // 并没有完全找完a,aaabaaaacaa这种，把最后的a和b交换
        ++count;
        res = Math.max(res, count);
        count = 1;
        last_ch = text.charAt(i);
      } else ++count;
    }
    //        if (count > 1 && ch_count[last_ch - 'a'] > count)
    //            ++count;
    return Math.max(res, count);
  }
}
