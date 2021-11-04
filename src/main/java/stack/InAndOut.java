package stack;

import java.util.Stack;

public class InAndOut {
  public boolean validateStackSequences(int[] pushed, int[] popped) {

    // 题目： 看popped能不能是pushed的一种出栈方式

    // 辅助栈，当然只需要一个栈，模拟进出，看最后出栈完成是否是一个空栈

    Stack<Integer> stack = new Stack<>();
    int index = 0;
    for (int i : pushed) {
      stack.push(i);

      // while 很重要， 因为有可能在中间不push,一直pop
      while (!stack.isEmpty() && popped[index] == stack.peek()) { // 直接等于是因为题说：每个元素都不一样
        stack.pop();
        index++;
      }
    }
    return stack.isEmpty();
    // stack.empty()
  }
}
