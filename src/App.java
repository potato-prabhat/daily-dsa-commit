import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static int findPivot(int[] arr) {
    int lo = 0;
    int hi = arr.length - 1;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (arr[mid] < arr[hi]) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return arr[hi];
  }

  public static void main(String[] args) {
    int[] arr1 = { 50, 10, 20, 30, 40 };
    int[] arr2 = { 30, 40, 50, 10, 20 };
    int[] arr3 = { 40, 50, 10, 20, 30 };
    System.out.println(findPivot(arr1));
    System.out.println(findPivot(arr2));
    System.out.println(findPivot(arr3));
  }
}
