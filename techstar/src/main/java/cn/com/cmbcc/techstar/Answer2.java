package cn.com.cmbcc.techstar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Answer2 {

    public static void doSomething(int[] nums)  {
        List<List<Integer>> result=threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] >  0) break;

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                if (nums[low] + nums[high] + nums[i] == 0) {
                    if (!hashSet.contains(Arrays.asList(nums[i], nums[low], nums[high]))) {
                        hashSet.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    }

                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;

                    low++;
                    high--;
                } else if (nums[low] + nums[high] + nums[i] > 0 ) {
                    high--;
                } else {
                    low++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) throws ParseException {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        doSomething(nums);
    }
}
