package basic;

import java.util.HashMap;
import java.util.Map;

public class BooleanAndboolean {

  public static void main(String[] args) {
    //  Boolean是它的封装类，和其他类一样，有属性有方法，可以new

    Boolean flag = new Boolean("true"); // boolean 则不可以！

    //  Boolean 是boolean 的实例化对象类，和Integer对应int一样，
    //  自jdk1.5.0以上版本后，Boolean在”赋值”和判断上和boolean一样，
    boolean b1 = true;
    Boolean b2 = true;
    Boolean b3 = b1;

    System.out.println(b1);
    System.out.println(b2);
    System.out.println(b3);

    boolean t = false;
    Map map = new HashMap();
    map.put("t", t);
    //    那么获取值时只能用
    Boolean t1 = (Boolean) map.get("t"); // 前面只能用Boolean强制转换，不能使用boolean.
    System.out.println(t1);

    System.out.println("-----------------");
    Boolean[] list = new Boolean[3];
    System.out.println(list);
    System.out.println(list[1]);
    list[2] = false;
    //        list[3] = false; 越界

    System.out.println("-----------------");
    boolean[] list1 = new boolean[3];
    System.out.println(list1[1]);
    //        System.out.println(list1[3]); 越界
  }
}
