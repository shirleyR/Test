package com.leetcode;


// two limit  --- order and sum to target
public class Solution1 {
	
	//Wrong idea
    public static int[] twoSum1(int[] nums, int target) {
    	int hash[];
    	int min=nums[0];
        int num[]=new int [2];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
        	if(nums[i]>max)max=nums[i];
        	if(nums[i]<min)min=nums[i];
        }
        
        	int s=max-min;
           	hash=new int [s+1];

            // without considering the same number add to a number???? 
        for(int i=0;i<nums.length;i++){
        	if(i>0&&hash[nums[i]-min]!=0)continue;
        	hash[nums[i]-min]=i;
        }
       for(int i=0;i<nums.length-1;i++){
    	   if(target-nums[i]>max)continue;
    	   if(target-nums[i]>=min){
    	   if(hash[target-nums[i]-min]>i){
    		   num[0]=i+1;
    		   num[1]=hash[target-nums[i]-min]+1;
    		   break;
    	   }
    	   }
       }
        return num;
    }
    public static int[] twoSum(int[] nums, int target) {
    	int hash[];
        int num[]=new int [2];
        int max=0;
        int flag=0;
        for (int i=0;i<nums.length-1;i++){
        	if(flag==1)break;
        	for(int j=i+1;j<nums.length;j++){
        		if(nums[i]+nums[j]==target){
        			num[0]=i+1;
        			num[1]=j+1;
        			break;
        		}
        	}
        }
        return num;
    }
    public static void main(String args[]){
    	int []nums={ 5,75,25};
    	int target=100;
    	int t[]=new int [2];
    			t=twoSum1(nums,target);
    	System.out.println(t[0]);
    }
}
