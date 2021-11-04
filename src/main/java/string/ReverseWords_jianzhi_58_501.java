package string;

public class ReverseWords_jianzhi_58_501 {

  //    输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
  //    标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

  public static void main(String[] args) {
    String test = "A   B C ";
    System.out.println(test.length());
    String test1 = test.trim();
    System.out.println(test1.length());
    String[] res = test1.split(" ");
    System.out.println(res.length);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i] + ":" + res[i].length());
    }
  }

  public String reverseWords(String s) {
    String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
    StringBuilder res = new StringBuilder();
    for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
      if (strs[i].equals("")) continue; // 遇到空单词则跳过
      res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
    }
    //    其实这个提示是表示方法使用不恰当，因为StringBuffer对象的append方法目的就是做对象拼接用的，
    //    里面再通过“+”来拼接就不得当，这是编译器对Ja  va的代码规范。
    //    不过实际操作过程中，如果涉及这类“+”拼接与append混合使用时，处理数据量多的话，还是忽略掉这个提示。
    return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
  }

  // 双指针
  public String reverseWords1(String s) {
    s = s.trim(); // 删除首尾空格
    int j = s.length() - 1, i = j;
    StringBuilder res = new StringBuilder();
    while (i >= 0) {
      while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
      res.append(s.substring(i + 1, j + 1)).append(" "); // 添加单词
      while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
      j = i; // j 指向下个单词的尾字符
    }
    return res.toString().trim(); // 转化为字符串并返回
  }
}
