package hot100.math;

public class P_169majorityElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3,3,4,4,4,4};
        int ans = mE(nums);
        System.out.println(ans);
    }

    //求绝对众数
    private static int mE(int[] nums) {
        int hp = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (hp == 0) {
                cur = nums[i];
                continue;
            }
            if (nums[i] == cur) {
                hp++;
            }else{
                hp--;
            }
        }
        return cur;
    }
}
