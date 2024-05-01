import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void targetSumPairPrint(int[] arr, int tar) {
    Arrays.sort(arr);
    int l = 0, r = arr.length - 1;
    while (l < r) {
      if (arr[l] + arr[r] > tar) {
        r--;
      } else if (arr[l] + arr[r] < tar) {
        l++;
      } else {
        System.out.println(arr[l] + " - " + arr[r]);
        r--;
        l++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = { 7, 15, 3, 18, 6, 4, 19, 2, 12, 11, 9 };
    targetSumPairPrint(arr, 15);
  }
}
