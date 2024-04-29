import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void quickSort(int[] arr, int lo, int hi) {
    if (lo > hi) {
      return;
    }
    int pivot = arr[hi];
    int pi = partition(arr, pivot, lo, hi);
    quickSort(arr, lo, pi - 1);
    quickSort(arr, pi + 1, hi);
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
    quickSort(arr, 0, arr.length - 1);
    for (int val : arr) {
      System.out.print(val + " ");
    }
  }
}
