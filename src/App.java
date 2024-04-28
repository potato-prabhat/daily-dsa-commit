import java.util.*;

public class App {

  public static void main(String[] args) {
    int[][] hc = {
      { 1, 5, 7, 2, 1, 4 },
      { 5, 8, 4, 3, 6, 1 },
      { 3, 2, 9, 7, 2, 3 },
      { 1, 2, 3, 9, 1, 7 },
    };
    int dp[][] = new int[hc.length][hc[0].length];
    for (int i = 0; i < hc.length; i++) {
      for (int j = 0; j < hc.length; j++) {
        if (i == 0) {
          dp[i][j] = hc[i][j];
        }
      }
    }
  }
}
