import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void main(String[] args) {
    int[] prices = { 11, 6, 7, 19, 4, 1, 6, 18, 4 };
    int least = Integer.MAX_VALUE;
    int mp = 0; //max profit
    int pt = 0; //profit if sold today

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < least) {
        least = prices[i];
      }
      pt = prices[i] - least;
      if (pt > mp) {
        mp = pt;
      }
    }
    System.out.println(mp);
  }
}
