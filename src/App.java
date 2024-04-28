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
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    for (int j = 0; j < hc[0].length; j++) {
      dp[0][j] = hc[0][j];
      if (hc[0][j] <= min1) {
        min2 = min1;
        min1 = hc[0][j];
      } else if (hc[0][j] <= min2) {
        min2 = hc[0][j];
      }
    }

    for (int i = 1; i < hc.length; i++) { // i is house number
      int tmin1 = Integer.MAX_VALUE;
      int tmin2 = Integer.MAX_VALUE;
      for (int j = 0; j < hc[0].length; j++) { // j is color number
        if (hc[i - 1][j] == min1) {
          dp[i][j] = hc[i][j] + min2;
        } else {
          dp[i][j] = hc[i][j] + min1;
        }
        if (dp[i][j] <= tmin1) {
          tmin2 = tmin1;
          tmin1 = dp[i][j];
        } else if (dp[i][j] <= tmin2) {
          tmin2 = dp[i][j];
        }
      }
      min1 = tmin1;
      min2 = tmin2;
    }
    int min = Integer.MAX_VALUE;
    for (int k = 0; k < dp[0].length; k++) {
      if (dp[dp.length - 1][k] < min) {
        min = dp[dp.length - 1][k];
      }
    }
    System.out.println(min);
  }
}
