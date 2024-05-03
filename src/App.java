public class App {

  public static void main(String[] args) {
    int[] prices = { 9, 6, 7, 6, 3, 8 };
    int k = 3;
    int[][] dp = new int[k + 1][prices.length];

    for (int t = 1; t <= k; t++) {
      for (int d = 1; d < prices.length; d++) {
        int max = dp[t][d - 1];
        for (int pd = 0; pd < d; pd++) {
          int ptilltm1 = dp[t - 1][pd];
          int ptth = prices[d] - prices[pd];
          max = Math.max(max, ptilltm1 + ptth);
        }
        dp[t][d] = max;
      }
    }
    System.out.println(dp[k][prices.length - 1]);
  }
}
