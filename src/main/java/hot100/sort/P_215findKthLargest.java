package hot100.sort;

import java.util.Deque;
import java.util.Random;

public class P_215findKthLargest {
    private static final Random rand = new Random();
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int ans = findK(nums, k);
        System.out.println(ans);
    }

    private static int findK(int[] nums, int k) {
        int n = nums.length;
        int KIndex = n-k;
        int l = 0;
        int r = n-1;
        while (true) {
            int i = partition(nums, l, r);
            if (i == KIndex) {
                return nums[i];
            }
            if (i>KIndex) {
                r = i - 1;
            }else{
                l = i +1;
            }
        }
        
    }

    //快排算法核心 分治
    private static int partition(int[] nums, int l, int r) {
       //step1 随机选择基础元素pivot
       int i = l + rand.nextInt(r - l + 1);
       int pivot = nums[i];
       swap(nums, i, l);

       //step2. 相向双指针遍历子数组
       i = l+1;
       int j = r;
       while (true) {
        while (i<=j && nums[i]< pivot) {
            i++;
        }
        while (i<=j && nums[j] > pivot) {
            j--;
        }
        if (i>=j) {
            break;
        }

        swap(nums, i, j);
        i++;
        j--;
       }
       swap(nums, l, j);
       return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
