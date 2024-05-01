import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void main(String[] args) {
    int n = 5, k = 3;
    int[] l2same = new int[n + 1];
    int[] l2diff = new int[n + 1];
    int[] tot = new int[n + 1];

    l2same[2] = k;
    l2diff[2] = k * (k - 1);
    tot[2] = l2same[2] + l2diff[2];

    for (int i = 3; i < tot.length; i++) {
      l2same[i] = l2diff[i - 1];
      l2diff[i] = tot[i - 1] * (k - 1);
      tot[i] = l2same[i] + l2diff[i];
    }

    int ways = tot[n];
    System.out.println(ways);
  }
}
