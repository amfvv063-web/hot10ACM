package hot100.math;

public class P_136singleNumber {
public static void main(String[] args) {
    int[] nums = {2,1,2};
    int ans = singeNumber(nums);
    System.out.println(ans);
}

//位运算
private static int singeNumber(int[] nums) {
    int ans = 0;
    for (int x : nums) {
        ans ^= x;
    }
    return ans;
}
}
