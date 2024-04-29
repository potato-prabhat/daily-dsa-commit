import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static int quickSelect(int[] arr, int lo, int hi, int k) {
    int pivot = arr[hi];
    int pi = partition(arr, pivot, lo, hi);
    if (k > pi) {
      return quickSelect(arr, pi + 1, hi, k);
    } else if (k < pi) {
      return quickSelect(arr, lo, pi - 1, k);
    } else {
      return arr[pi];
    }
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    //The unknown is from i to end of array.
    //Elements >pivot will be placed on j to i-1.
    //Elements ≤pivot will be placed on 0 to j-1.
    int i = lo, j = lo;
    while (i <= hi) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }
    return (j - 1);
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = { 8, 5, 1, 3, 7, 2, 9, 6 };
    int k = 4;
    int found = quickSelect(arr, 0, arr.length - 1, k - 1);
    System.out.println(found - 1);
  }
}
