import java.util.*;

public class App {

  public static void insertionSort(int[] arr) {
    for (int i = 1; i <= arr.length - 1; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (isGreater(arr, j, j + 1)) {
          swap(arr, j, j + 1);
        } else {
          break;
        }
      }
    }
    for (int val : arr) {
      System.out.print(val + " ");
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static boolean isGreater(int[] arr, int j, int i) {
    if (arr[i] < arr[j]) return true; else return false;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 9, 5, 1, 3 };
    insertionSort(arr);
  }
}
