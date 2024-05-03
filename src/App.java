import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void main(String[] args) {
    int[] arr = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
    int fee = 3;

    int obsp = -arr[0];
    int ossp = 0;
    for (int i = 1; i < arr.length; i++) {
      int nbsp = 0;
      int nssp = 0;
      if (ossp - arr[i] > obsp) {
        nbsp = ossp - arr[i];
      } else {
        nbsp = obsp;
      }

      if (obsp + arr[i] - fee > ossp) {
        nssp = obsp + arr[i] - fee;
      } else {
        nssp = ossp;
      }
      obsp = nbsp;
      ossp = nssp;
    }
    System.out.println(ossp);
  }
}
