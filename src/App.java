import java.util.*;

public class App {

  static class Student implements Comparable<Student> {

    int rno;
    int ht;
    int wt;

    Student(int rno, int ht, int wt) {
      this.rno = rno;
      this.ht = ht;
      this.wt = wt;
    }

    public int compareTo(Student o) {
      return this.rno - o.rno;
    }

    public String toString() {
      return "ro = " + this.rno + ", ht = " + this.ht + ", wt = " + this.wt;
    }
  }

  public static void main(String[] args) {
    PriorityQueue<Student> qu = new PriorityQueue<>();

    qu.add(new Student(10, 180, 81));
    qu.add(new Student(2, 185, 85));
    qu.add(new Student(12, 170, 84));
    qu.add(new Student(18, 179, 88));
    qu.add(new Student(7, 182, 82));
    while (qu.size() > 0) {
      System.out.println(qu.peek());
      qu.remove();
    }
  }
}
