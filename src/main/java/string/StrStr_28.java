package string;

public class StrStr_28 {

  //    28. 实现 strStr()

  //    实现strStr()函数。
  //    给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回-1 。
  //    当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
  //
  //    对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。

  public static void prefix_table(char[] pattern, int[] prefix) {
    // 没有后移的prefix_table，prefix_table[i]表示的是前i+1个字母的最长公共前后缀长度
    prefix[0] = 0;
    int n = pattern.length;
    for (int i = 1; i < n; i++) {
      int k = prefix[i - 1];
      // 不断递归判断是否存在子对称，k=0说明不再有子对称，Pattern[i] != Pattern[k]说明虽然对称，但是对称后面的值和当前的字符值不相等，
      // 所以继续递推
      while (pattern[i] != pattern[k] && k != 0) {
        k = prefix[k - 1]; // 继续递归
      }
      if (pattern[i] == pattern[k]) { // 找到了这个子对称，或者是直接继承了前面的对称性，这两种都在前面的基础上++
        prefix[i] = k + 1;
      } else { // k==0
        prefix[i] = 0; // 如果遍历了所有子对称都无效，说明这个新字符不具有对称性，清0
      }
    }
  }

  public static void move_prefix_table(int[] prefix, int n) { // 整体向右移动一位，有利于些kmp
    for (int i = n - 1; i > 0; i--) {
      prefix[i] = prefix[i - 1];
    }
    prefix[0] = -1;
  }

  public static void kmp_search(char[] text, char[] pattern) {
    int n = pattern.length;
    int[] prefix = new int[n];
    prefix_table(pattern, prefix);
    move_prefix_table(prefix, n);
    // text[i] len(text) = m
    // pattern[j] len(pattern) = n
    int m = text.length;
    int j = 0;
    int i = 0;
    while (i < m) { // 搜索text
      if (j == n - 1 && text[i] == pattern[j]) { // 匹配成功
        System.out.println(i - j); // 索引
        // 继续匹配，看看还有没有
        j = prefix[j];
      }
      if (text[i] == pattern[j]) {
        i++;
        j++;
      } else { // 不等
        j = prefix[j]; // 相当于就是后移pattern串
        // 不等 且 j=0 -> j=-1 = prefix[j] = -1
        if (j == -1) { // -1很必要,因为-1不自增为0的话，索引会越界的
          j++; // j回归到0
          i++;
        }
      }
    }
  }

  public static void main(String[] args) {
    String pat = "ababcabaa";
    int[] prefix = new int[pat.length()];
  }

  public int strStr(String haystack, String needle) {
    char[] pattern = needle.toCharArray();
    char[] text = haystack.toCharArray();
    int n = pattern.length;
    int[] prefix = new int[n];
    prefix_table(pattern, prefix);
    move_prefix_table(prefix, n);
    // text[i] len(text) = m
    // pattern[j] len(pattern) = n
    int m = text.length;
    int j = 0;
    int i = 0;
    while (i < m) { // 搜索text
      if (j == n - 1 && text[i] == pattern[j]) { // 匹配成功
        return i - j;
        //                System.out.println(i-j); //索引
        // 继续匹配，看看还有没有
        //                j = prefix[j];
      }
      if (text[i] == pattern[j]) {
        i++;
        j++;
      } else { // 不等
        j = prefix[j]; // 相当于就是后移pattern串
        // 不等 且 j=0 -> j=-1 = prefix[j] = -1
        if (j == -1) { // -1很必要,因为-1不自增为0的话，索引会越界的
          j++; // j回归到0
          i++;
        }
      }
    }
    return -1;
  }
}
