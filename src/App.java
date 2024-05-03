public class App {

  public static void main(String[] args) {
    int[] prices = {
      30,
      40,
      43,
      50,
      45,
      20,
      26,
      40,
      80,
      50,
      30,
      15,
      10,
      20,
      40,
      45,
      71,
      50,
      55,
    };
    if (prices.length == 0) {
      System.out.println(0);
      return;
    }

    int n = prices.length;
    int[] dpmpisut = new int[n]; // max profit if sold up to today
    int[] dpmpibat = new int[n]; // max profit if bought today or after today

    int leastut = prices[0];
    dpmpisut[0] = 0;
    for (int i = 1; i < n; i++) {
      leastut = Math.min(leastut, prices[i]);
      dpmpisut[i] = Math.max(dpmpisut[i - 1], prices[i] - leastut);
    }

    int maxat = prices[n - 1];
    dpmpibat[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      maxat = Math.max(maxat, prices[i]);
      dpmpibat[i] = Math.max(dpmpibat[i + 1], maxat - prices[i]);
    }

    int maxSum = 0;
    for (int i = 0; i < n; i++) {
      maxSum = Math.max(maxSum, dpmpisut[i] + dpmpibat[i]);
    }

    System.out.println(maxSum);
  }
}
