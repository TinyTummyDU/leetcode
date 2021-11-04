package string;

import java.util.*;

public class ReverseWords_501 {

  public static void main(String[] args) {
    StringBuilder word = new StringBuilder();
    word.append('a');
    word.append('b');
    System.out.println(word.length());
    System.out.println(word.toString());
    word.setLength(0);
    System.out.println(word.toString());
  }

  public String reverseWords(String s) {
    // 除去开头和末尾的空白字符
    s = s.trim();
    // 正则匹配连续的空白字符作为分隔符分割
    List<String> wordList = Arrays.asList(s.split("\\s+"));
    Collections.reverse(wordList);
    return String.join(" ", wordList);
  }

  public String reverseWords1(String s) {
    int left = 0, right = s.length() - 1;
    // 去掉字符串开头的空白字符
    while (left <= right && s.charAt(left) == ' ') {
      ++left;
    }
    // 去掉字符串末尾的空白字符
    while (left <= right && s.charAt(right) == ' ') {
      --right;
    }

    Deque<String> d = new ArrayDeque<String>();
    StringBuilder word = new StringBuilder();

    while (left <= right) {
      char c = s.charAt(left);
      if (c != ' ') {
        word.append(c);
      } else {
        if (word.length() != 0) {
          d.offerFirst(word.toString()); // 头插
          word.setLength(0); // 顺便清空了Stringbuilder
        }
      }
      ++left;
    }
    d.offerFirst(word.toString()); // 最后一个因为没有空格了，需要在while循环外面单独处理

    return String.join(" ", d);
  }
}
