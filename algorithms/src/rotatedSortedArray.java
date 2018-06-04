public class rotatedSortedArray {

    public static int findMinimum(int num[]) {

        if(num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }

        int low = 0;
        int high = num.length - 1;


        while(low < high) {
            int mid = low + (high - low) / 2;

            if (num[mid] > num[high]) {
                low = mid + 1;
            }
            else if (num[mid] < num[high]) {
                high = mid;
            }
            else {
                high--;
            }
        }
        return num[low];

    }

    public static int searchRotatedSorted(int nums[], int target) {
        if(nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start < end ) {
            int mid = start + (end - start)/2;

            if(nums[mid] == target) {
                return mid;
            }

            else if(nums[start] <= nums[mid]) {
                if(target < nums[start] || target > nums[mid]) {
                   start = mid +1;
                } else {
                    end = mid;
                }
            } else if(nums[start] > nums[mid]){
                if(target > nums[mid] && target < nums[start]) {
                    start = mid +1;
                } else{
                    end = mid;
                }
            }
        }

        return -1;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int num[] = {4,5,6,7,1,2,3};
        System.out.println(findMinimum(num));

        System.out.println(searchRotatedSorted(num, 2));

    }

}