package stack;

public class TripleInOne {
  // 面试题 03。01

  // 数组的下标为[0, 0 + 3, ... , 0 + 3 * (stackSize - 1)]存放stack_0
  // 数组的下标为[1, 1 + 3, ... , 1 + 3 * (stackSize - 1)]存放stack_1
  // 数组的下标为[2, 2 + 3, ... , 2 + 3 * (stackSize - 1)]存放stack_2;
  private int[] arr;
  // 每个栈当前可push到的索引（对应到arr中的索引）
  private int stackTop0, stackTop1, stackTop2;
  private int stackSize; // 每个栈的大小

  public TripleInOne(int stackSize) {
    this.stackSize = stackSize;
    arr = new int[stackSize * 3];
    stackTop0 = 0;
    stackTop1 = 1;
    stackTop2 = 2;
  }

  public void push(int stackNum, int value) {
    int curStackTop;
    switch (stackNum) {
      case 0:
        curStackTop = stackTop0;
        break;
      case 1:
        curStackTop = stackTop1;
        break;
      case 2:
        curStackTop = stackTop2;
        break;
      default:
        curStackTop = -1;
        return;
    }
    if (curStackTop / 3 == stackSize) {
      // 栈已满
      return;
    }
    arr[curStackTop] = value;
    switch (stackNum) {
      case 0:
        stackTop0 += 3;
        break;
      case 1:
        stackTop1 += 3;
        break;
      case 2:
        stackTop2 += 3;
        break;
    }
  }

  public int pop(int stackNum) {
    if (isEmpty(stackNum)) {
      return -1;
    }
    int value;
    switch (stackNum) {
      case 0:
        value = arr[stackTop0 - 3];
        stackTop0 -= 3;
        break;
      case 1:
        value = arr[stackTop1 - 3];
        stackTop1 -= 3;
        break;
      case 2:
        value = arr[stackTop2 - 3];
        stackTop2 -= 3;
        break;
      default:
        value = -1;
    }
    return value;
  }

  public int peek(int stackNum) {
    if (isEmpty(stackNum)) {
      return -1;
    }
    switch (stackNum) {
      case 0:
        return arr[stackTop0 - 3];
      case 1:
        return arr[stackTop1 - 3];
      case 2:
        return arr[stackTop2 - 3];
      default:
        return -1;
    }
  }

  public boolean isEmpty(int stackNum) {
    switch (stackNum) {
      case 0:
        return stackTop0 == 0;
      case 1:
        return stackTop1 == 1;
      case 2:
        return stackTop2 == 2;
      default:
        return false;
    }
  }
}
