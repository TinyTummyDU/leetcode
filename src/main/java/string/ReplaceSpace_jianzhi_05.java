package string;

public class ReplaceSpace_jianzhi_05 {

  //    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

  //    此方法还是无法将空间复杂度降至 O(1) ，因为字符串为不可变对象，即扩充原字符串也会建立新的字符串对象。

  //    在 Python 和 Java 等语言中，字符串都被设计成「不可变」的类型，即无法直接修改字符串的某一位字符，需要新建一个字符串实现。
  public String replaceSpace(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ') stringBuilder.append("%20");
      else stringBuilder.append(c);
    }
    return stringBuilder.toString();
  }

  public String replaceSpace1(String s) {
    return s.replace(" ", "%20");
  }
}
