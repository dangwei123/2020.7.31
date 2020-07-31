给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-array-largest-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int splitArray(int[] nums, int m) {
        int max=0;
        int sum=0;
        for(int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        int left=max;
        int right=sum;
        while(left<right){
            int mid=left+(right-left)/2;
            int count=0;
            int tmp=0;
            for(int num:nums){
                tmp+=num;
                if(tmp>mid){
                    count++;
                    tmp=num;
                }
            }
            count++;
            if(count>m){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}