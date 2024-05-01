import java.util.*;
import javax.lang.model.util.Elements;

public class App {

  public static void radixSort(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int val : nums) {
      if (val > max) {
        max = val;
      }
    }

    int exp = 1;
    while (exp <= max) {
      countSort(nums, exp);
      exp = exp * 10;
    }
    printnums(nums);
  }

  public static void countSort(int[] nums, int exp) {
    int[] freqnums = new int[10];
    int[] ansnums = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      freqnums[nums[i] / exp % 10]++;
    }
    for (int i = 1; i < freqnums.length; i++) {
      freqnums[i] = freqnums[i] + freqnums[i - 1];
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      ansnums[freqnums[(nums[i] / exp) % 10] - 1] = nums[i];
      freqnums[(nums[i] / exp) % 10]--;
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = ansnums[i];
    }
  }

  public static void printnums(int[] nums) {
    for (int val : nums) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = { 213, 97, 718, 123, 37, 443, 982, 64, 375, 683 };
    // int[] nums = { 9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9 };
    radixSort(nums);
  }
}
