import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void main(String[] args) {
    int[] prices = { 1, 2, 3, 4, 5 };
    int buyd = 0;
    int selld = 0;
    int tp = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] >= prices[i - 1]) {
        selld++;
      } else {
        tp += prices[selld] - prices[buyd];
        buyd = selld = i;
      }
    }
    tp += prices[selld] - prices[buyd];
    System.out.println(tp);
  }
}
