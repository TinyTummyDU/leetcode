package general;

public class PrintNumberForNDigits {
  //    public static int[] printNumbers(int n) {
  //        int num = 0;
  //        for(int i=1;i<=n;i++){
  //            num+=9* Math.pow(10,i-1);
  //        }
  //
  //        int[] res = new int[num];
  //        for(int j = 1; j<=num; j++){
  //            res[j-1] = j;
  //        }
  //        return res;
  //    }
  //    public int[] printNumbers1(int n) {
  //        int end = (int)Math.pow(10, n) - 1;
  //        int[] res = new int[end];
  //        for(int i = 0; i < end; i++)
  //            res[i] = i + 1;
  //        return res;
  //    }
  //
  //
  //
  //
  //
  //    //大数问题
  //
  //    public StringBuilder res;
  //    public int count = 0, n;
  //    public char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  //    public static String printNumbers2(int n) {
  //
  //        this.n = n;
  //        res = new StringBuilder(); // 数字字符串集
  //        num = new char[n]; // 定义长度为 n 的字符列表
  //        dfs(0); // 开启全排列递归
  //        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
  //        return res.toString(); // 转化为字符串并返回
  //    }
  //    public static void dfs(int x) {
  //        if(x == n) { // 终止条件：已固定完所有位
  //            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
  //            return;
  //        }
  //        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
  //            num[x] = i; // 固定第 x 位为 i
  //            dfs(x + 1); // 开启固定第 x + 1 位
  //        }
  //    }
  //
  //
  //    public static void main(String[] args) {
  //
  //        System.out.println(printNumbers2(1));
  //    }

}
