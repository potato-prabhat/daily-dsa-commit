import java.util.*;

public class App {

  public static void main(String[] args) {
    int[] arr = { 5, 10, 10, 100, 5, 6 };
    int oldi, newi, olde, newe;
    oldi = arr[0];
    olde = 0;
    for (int i = 1; i < arr.length; i++) {
      newi = arr[i] + olde;
      newe = Math.max(oldi, olde);
      olde = newe;
      oldi = newi;
    }
    System.out.println(Math.max(oldi, oldi));
  }
}
