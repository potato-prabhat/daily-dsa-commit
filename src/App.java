import java.util.*;

public class App {

  public static void selectionSort(int[] arr) {
    int mi;
    for (int i = 0; i < arr.length - 1; i++) {
      mi = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (isSmaller(arr, j, mi)) {
          mi = j;
        }
      }
      swap(arr, i, mi);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static boolean isSmaller(int[] arr, int i, int j) {
    if (arr[i] < arr[j]) return true; else return false;
  }

  public static void main(String[] args) {
    int[] arr = { 5, 9, 8, 2, 1 };
    selectionSort(arr);
  }
}
