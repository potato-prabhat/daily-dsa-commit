import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void countSort(int[] arr, int min, int max) {
    int range = max - min + 1;
    int[] freqArr = new int[range];
    for (int val : arr) {
      freqArr[val - min]++;
    }

    for (int i = 1; i < freqArr.length; i++) {
      freqArr[i] = freqArr[i] + freqArr[i - 1];
    }
    int[] ansArr = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      ansArr[freqArr[arr[i] - min] - 1] = arr[i];
      freqArr[arr[i] - min]--;
    }

    printArr(ansArr);
  }

  public static void printArr(int[] arr) {
    for (int val : arr) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9 };
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int val : arr) {
      max = Math.max(val, max);
      min = Math.min(val, min);
    }
    countSort(arr, min, max);
  }
}
