import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void main(String[] args) {
    int[] arr = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
    int obsp = -arr[0];
    int ossp = 0;
    int ocsp = 0;

    for (int i = 1; i < arr.length; i++) {
      int nbsp = 0, nssp = 0, ncsp = 0;
      if (ocsp - arr[i] > obsp) {
        nbsp = ocsp - arr[i];
      } else {
        nbsp = obsp;
      }
      if (obsp + arr[i] > ossp) {
        nssp = obsp + arr[i];
      } else {
        nssp = ossp;
      }
      if (ossp > ocsp) {
        ncsp = ossp;
      } else {
        ncsp = ocsp;
      }
      obsp = nbsp;
      ossp = nssp;
      ocsp = ncsp;
    }
    System.out.println(ossp);
  }
}
