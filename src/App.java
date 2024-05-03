import java.util.*;
import javax.lang.model.util.Elements;

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
    int leastut = Integer.MAX_VALUE; //least upto today
    int mpist = 0; // max profit if sold today
    int[] dpmpisut = new int[prices.length]; // max profit if sold upto today
    dpmpisut[0] = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < leastut) {
        leastut = prices[i];
      }
      mpist = prices[i] - leastut;
      if (mpist > dpmpisut[i - 1]) {
        dpmpisut[i] = mpist;
      } else {
        dpmpisut[i] = dpmpisut[i - 1];
      }
    }
    int maxat = prices[prices.length - 1]; //max at today
    int mpibt = 0; // max profit if bought today
    int[] dpmpibat = new int[prices.length]; // max profit if bought today or after today

    for (int i = prices.length - 2; i >= 0; i--) {
      if (prices[i] > maxat) {
        maxat = prices[i];
      }
      mpibt = maxat - prices[i];
      if (mpibt > dpmpibat[i + 1]) {
        dpmpibat[i] = mpibt;
      } else {
        dpmpibat[i] = dpmpibat[i + 1];
      }
    }
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < dpmpibat.length; i++) {
      maxSum = Math.max(maxSum, dpmpibat[i] + dpmpisut[i]);
    }
    System.out.println(maxSum);
  }
}
