package general;

public class ThreeConsecutiveOdds {

  public boolean threeConsecutiveOdds(int[] arr) {
    int len = arr.length;
    for (int i = 0; i <= len - 3; i++) {
      if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
        return true;
      }
    }
    return false;
  }
}
