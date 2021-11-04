package string;

public class Hello {
  public static void main(String[] args) {
    StringBuilder word = new StringBuilder();
    word.append('a');
    word.append('b');
    System.out.println(word.length());
    System.out.println(word.toString());
    word.setLength(0);
    System.out.println(word.toString());
    System.out.println("********");
  }
}
