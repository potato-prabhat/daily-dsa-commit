import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static int[] mergeSort(int[] arr, int lo, int hi) {
    if (lo == hi) {
      int[] ba = new int[1];
      ba[0] = arr[lo];
      return ba;
    }

    int mid = (lo + hi) / 2;
    int[] fsh = mergeSort(arr, lo, mid);
    int[] lsh = mergeSort(arr, mid + 1, hi);
    int[] fsa = mergeSortedArray(fsh, lsh);
    return fsa;
  }

  public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
    int[] arr3 = new int[arr1.length + arr2.length];
    int i = 0, j = 0, k = 0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        arr3[k] = arr1[i];
        i++;
      } else {
        arr3[k] = arr2[j];
        j++;
      }
      k++;
    }
    while (i < arr1.length) {
      arr3[k] = arr1[i];
      i++;
      k++;
    }
    while (j < arr2.length) {
      arr3[k] = arr2[j];
      j++;
      k++;
    }
    return arr3;
  }

  public static void targetSumPairPrint(int[] arr, int tar) {
    int[] sortedArr = mergeSort(arr, 0, arr.length - 1);
    int l = 0, r = sortedArr.length - 1;
    while (l < r) {
      if (sortedArr[l] + sortedArr[r] > tar) {
        r--;
      } else if (sortedArr[l] + sortedArr[r] < tar) {
        l++;
      } else {
        System.out.println(sortedArr[l] + " - " + sortedArr[r]);
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
