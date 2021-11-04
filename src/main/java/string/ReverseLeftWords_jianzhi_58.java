package string;

public class ReverseLeftWords_jianzhi_58 {

  public static String reverseLeftWords(String s, int n) {

    char[] chars = s.toCharArray();
    int j = 0;
    for (int i = n; i < s.length(); i++) {
      chars[j] = s.charAt(i);
      System.out.println(chars[j]);
      j++;
    }
    for (int i = 0; i < n; i++) {
      chars[j] = s.charAt(i);
      System.out.println(chars[j]);
      j++;
    }
    //        System.out.println(String.valueOf(chars));

    return String.valueOf(chars);
  }

  public static void main(String[] args) {
    reverseLeftWords("abcdefg", 2);
  }
}
