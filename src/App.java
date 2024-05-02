import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void main(String[] args) {
    int m = 3;
    int n = 8;

    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      if (i < m) {
        dp[i] = 1;
      } else if (i == m) {
        dp[i] = 2;
      } else {
        dp[i] = dp[i - 1] + dp[i - m];
      }
    }
    System.out.println(dp[n]);
  }
}
