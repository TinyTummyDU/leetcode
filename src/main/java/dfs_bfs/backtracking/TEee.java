package dfs_bfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEee {

  public static void main(String[] args) {

    List<List<Integer>> newL = new ArrayList<>();
    newL.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
    newL.add(newL.get(0));
    System.out.println(newL.size());
    newL.get(1).set(0, 4);
    System.out.println(newL.get(0));
    // ArrayList里的元素能被打印出来，是因为其重写了toString方法
    // 打印对象就是调用对象本身tostring方法，默认tostring方式是输出地址。
    // 某些类重写tostring方法用来输出内容。Arraylist就是重写了tostring方法，所以输出的是Arraylist的内容

    //        这是因为ArrayList 的toString方法重写了。但是这个方法不是在Arraylist中被重写的，而是在其继承类中被重写的，
    //        他继承自Abstracetlist,Abstracetlist继承自AbstractCollection，
    //        AbstractCollection中的tostring（）方法为：
    //        返回此 collection 的字符串表示形式。
    //        该字符串表示形式由 collection 元素的列表组成，
    //        这些元素按其迭代器返回的顺序排列，并用方括号 ("[]") 括起来。相邻元素由字符 ", "（逗号加空格）分隔。

    // 接口可以继承接口，但是类只可以实现接口
  }
}
