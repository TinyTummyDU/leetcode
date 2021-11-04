package string;

public class Palindrome {
  public static void main(String[] args) {
    String abc = "asn";
    System.out.println(abc.charAt(1));
  }

  public boolean isPalindrome(String s) {
    StringBuffer sgood = new StringBuffer();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sgood.append(Character.toLowerCase(ch));
      }
    }
    int n = sgood.length();
    int left = 0, right = n - 1;
    while (left < right) {
      if (sgood.charAt(left) != sgood.charAt(right)) {
        return false;
      }
      ++left;
      --right;
    }
    return true;
  }
}
