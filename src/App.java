import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void sort01(int[] arr) {
    int i = 0, j = 0, k = arr.length - 1;
    while (i <= k) {
      if (arr[i] == 0) {
        swap(arr, i, j);
        i++;
        j++;
      } else if (arr[i] == 1) {
        i++;
      } else {
        swap(arr, i, k);
        k--;
      }
    }
    printArr(arr);
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void printArr(int[] arr) {
    for (int val : arr) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 2, 0, 1, 2, 2, 1, 0, 1, 2, 0, 2, 1 };
    sort01(arr);
  }
}
