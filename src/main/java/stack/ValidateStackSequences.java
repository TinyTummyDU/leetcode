package stack;

import java.util.Stack;

public class ValidateStackSequences {

  // 946

  public boolean validateStackSequences(int[] pushed, int[] popped) {

    Stack<Integer> mimic = new Stack<>();
    int popNum = 0;
    for (int i : pushed) {
      mimic.push(i);
      while (!mimic.isEmpty() && mimic.peek() == popped[popNum]) {
        mimic.pop();
        popNum++;
      }
    }
    return popNum == pushed.length;
  }
}
