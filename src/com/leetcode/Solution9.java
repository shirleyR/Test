package com.leetcode;

public class Solution9 {
	public boolean isPalindrome(int x) {
		int rev=0;
		int temp[]=new int [11];
		int mina[]={-2,-1,-4,-7,-4,-8,-3,-6,-4,-8};
		int maxa[]={2,1,4,7,4,8,3,6,4,7};
		int i;
		int tzero=0;
		int tag=0;
		if(x<0)return false;
		if(x==0)return true;
		for( i=0;i<10;i++){
			temp[i]=x%10;
			if(temp[i]==0&&tag==0)tzero++;
			else{
				tag=1;
			}
			x=x/10;
			if(x==0)break;
		}
		if(tzero>0)return false;
		for(int k=0,l=i;k<=l;k++,l--){
			if(temp[k]!=temp[l]) return false;
		}
	
		return true;
	}

	public static void main(String args[]){
		Solution9 t=new Solution9();
		System.out.println(t.isPalindrome(-101));
	}

}
