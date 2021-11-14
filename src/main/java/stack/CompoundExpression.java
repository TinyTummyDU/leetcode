package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: CompoundExpression @Description: todo @Author Yuqi Du @Date 2021/11/12 3:58
 * 下午 @Version 1.0
 */
public class CompoundExpression {

  public static Map<Character, Integer> priority =
      new HashMap<Character, Integer>() {
        {
          put('(', 0);
          put('+', 1);
          put('-', 1);
          put('*', 2);
          put('/', 2);
          put(')', 3);
        }
      };

  public static void calculate(String target) {
    char[] elements = target.toCharArray();
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < elements.length; i++) {
      char cur = elements[i];
      System.out.println("cur: " + cur);
      int temp = 0;
      if (cur >= '0' && cur <= '9') { // is a num
        temp = cur - '0';
        i = i + 1;
        while (i < target.length() && elements[i] >= '0' && elements[i] <= '9') {
          temp = temp * 10 + (elements[i] - '0');
          i++;
        }
        i--; // 对应上面一句i = i+1;因为在for循环中有i++自增操作，若不执行此句，会导致i自增两次
        operands.push(temp);
      } else {
        if (operators.isEmpty()) { // empty
          operators.add(cur);
        } else { // not empty
          System.out.println("-----");
          char temp1 = operators.pop(); // 进栈前，存放运算符栈中栈顶存放字符
          System.out.println(temp1);
          int judge = comparePriority(temp1, cur); // 比较当前字符与栈顶字符优先级
          System.out.println(judge);
          if (judge == 1) { // 当前字符优先级小于栈顶字符
            int tempA = operands.pop();
            int tempB = operands.pop();
            int result = computeNumber(tempB, tempA, temp1);
            operands.push(result);
            operators.push(cur);
          }
          if (judge == 0) { // 当前字符优先级大于栈顶字符
            operators.push(temp1);
            operators.push(cur);
          }
          if (judge == 2) { // 字符')'遇到'('，刚好使得'('出栈
            System.out.println("'('刚好遇到')'"); // 这种情况也应该不会出现，按照给定优先级，')'一般会先遇到+、-、*、/字符
          }
          if (judge == 3) { // 此时')'刚好准备进栈
            while (temp1 != '(') { // ')'字符要等到第一个'('出栈才能结束循环
              System.out.println("找(: " + temp1);
              int tempA = operands.pop();
              int tempB = operands.pop();
              int result = computeNumber(tempB, tempA, temp1);
              operands.push(result);
              temp1 = operators.pop();
            }
          }
          if (judge == -1) { // 此时，说明当前栈顶字符为')'，这是不存在的，因为遇到')'，按要求不让进栈
            System.out.println("出现栈顶有')'错误！！！");
          }
        }
      }
    }
    while (!operators.empty() && !operands.empty()) { // 此时，字符栈中还存在运算符的情况
      char temp1 = operators.pop();
      int tempA = operands.pop();
      int tempB = operands.pop();
      int result = computeNumber(tempB, tempA, temp1);
      operands.push(result);
    }
    System.out.println(operands.pop()); // 此时运算符栈为空，数字栈中只存在表达式计算最终结果
  }

  // 计算a operator b的值，operator = {+,-,*,/}
  public static int computeNumber(int a, int b, char operator) {
    int result;
    switch (operator) {
      case '+':
        result = a + b;
        break;
      case '-':
        result = a - b;
        break;
      case '*':
        result = a * b;
        break;
      case '/':
        result = a / b;
        break;
      default:
        result = 0;
        break;
    }
    return result;
  }

  public static int comparePriority(char pre, char cur) {
    if (cur != ')') {
      if (cur == '(') { // (10-11)+(20+30)
        return 0; // 遇见(，直接加入(，先不算
      }
      // cur为 + - * /
      if (priority.get(cur) <= priority.get(pre)) { // 后面的比前面的 小 或者 一样 a*b-c   a*b/c，都是直接算前面的就行
        return 1;
      }
      return 0; // 后面的比前面的 大  先加入，不要算
    } else { // cur == ')'
      if (pre != '(') {
        return 3;
      }
      return 2;
    }
  }

  public static void main(String[] args) {
    //    calculate("1+2*2+1");
    calculate("(10-11)+(20+30)");
    calculate("(10-11)+1*3-9+(20+30)*1");
  }
}
