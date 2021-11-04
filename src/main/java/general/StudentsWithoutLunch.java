package general;

public class StudentsWithoutLunch {
  // 1700

  public int countStudents(int[] students, int[] sandwiches) {
    if (students == null || students.length == 0) return 0;
    if (sandwiches == null || sandwiches.length == 0) return students.length;

    int[] studentLike = new int[2];
    for (int st : students) {
      studentLike[st]++;
    }

    for (int sa : sandwiches) {

      if (studentLike[sa] == 0) { // 最顶上的那一块 谁都拿不走
        break;
      }
      studentLike[sa]--;
    }
    return studentLike[0] + studentLike[1];
  }
}
