import java.util.HashMap;

public class maxKsubarray {

    public static int maxSizeSubarray(int nums[], int K) {
        if(nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;
        map.put(0, -1);


        for(int i=0; i< nums.length;i++) {
            sum += nums[i];

            int diff = sum - K;
            if(map.containsKey(diff)) {
                    maxLen = Math.max(maxLen, i-map.get(diff));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }


    public static void main(String []args) {
        int nums[] = {1,2,-3,3,-1,2,4};
        System.out.println(maxSizeSubarray(nums, 3));

        int nums2[] = {1, -1, 5, -2, 3};
        System.out.println(maxSizeSubarray(nums2, 3));

        int nums3[] = {-2, -1, 2, 1};
        System.out.println(maxSizeSubarray(nums3, 1));
    }
}