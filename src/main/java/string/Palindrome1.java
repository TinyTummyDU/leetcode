package string;

public class Palindrome1 {
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        ++left;
        --right;
      } else {
        //                return isPalindrome1(s,++left,right)||isPalindrome1(s,left,--right);
        // 不对，这样就改变了left和right 了
        return isPalindrome1(s, left + 1, right) || isPalindrome1(s, left, right - 1);
      }
    }
    return true;
  }

  public boolean isPalindrome1(String s, int l, int r) {
    for (int i = l, j = r; i < j; ++i, --j) { // 三部分就行，大部分使用；隔开
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
