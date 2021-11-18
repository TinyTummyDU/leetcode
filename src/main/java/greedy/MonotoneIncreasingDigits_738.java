package greedy;

public class MonotoneIncreasingDigits_738 {

//    这是一道很明显的贪心题目。既然要尽可能的大，那么这个数从高位开始要尽可能地保持不变。那么我们找到从高到低第一个满足
//    str[i]>str[i+1] 的位置，然后把 str[i]−1 ，再把后面的位置都变成9 即可。对应可看下面的例子。


    //操作字符

    /**
     * 思路：
     * 从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
     * 则把其左边一位数字减1，并将该位及其右边的所有位改成9
     */
    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        char[] chars = s.toCharArray();
        int flag = length;
        for (int i = length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));

    }


//    同样的思路，数学运算加递归非常简洁

    public static int iterate(int n) {
        for (int i = n, j = 9, k = 1; i > 0; i /= 10, k *= 10) {
//            if (j < (j = i % 10)) {
            if (j < i % 10) {
                return iterate(i * k - 1);
            }
            j = i % 10;
        }
        return n;
    }

}
