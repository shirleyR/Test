package com.leetcode;

/**
 *   reverse integer 
 *   special:
 *   		1. with 0 in the end  eg. 100 10 0
 *   		2. overflow 
 *   		3. 32-bit min:-2147483648 max:2147483647  
 * @author rsl
 *
 */

public class Solution7 {
	public int reverse(int x) {
		int rev=0;
		int temp[]=new int [11];
		int mina[]={-2,-1,-4,-7,-4,-8,-3,-6,-4,-8};
		int maxa[]={2,1,4,7,4,8,3,6,4,7};
		int i;
		int tzero=0;
		int tag=0;
		for( i=0;i<10;i++){
			temp[i]=x%10;
			if(temp[i]==0&&tag==0)tzero++;
			else{
				tag=1;
			}
			x=x/10;
			if(x==0)break;
		}
		if(i>=9){
			if(temp[tzero]<0){
				int j=0;
				int tt=0;
				for(;tzero<=i;tzero++){
					if(temp[tzero]<mina[j]&&tt==0){return 0;}
					else if(temp[tzero]<mina[j]) tt=1;
					rev=rev*10+temp[tzero];
					j++;
				}
				
			}else{
				int j=0;
				int tt=0;
				for(;tzero<=i;tzero++){
					if(temp[tzero]>maxa[j]&&tt==0){return 0;}
					else
						if(temp[tzero]<maxa[j])tt=1;
					rev=rev*10+temp[tzero];
					j++;
				}
				
			}
		}else {
		
			for(;tzero<=i;tzero++){
				
				rev=rev*10+temp[tzero];
			}
		}
		
		return rev;
	}
	
	public static void main(String args[]){
			Solution7 t=new Solution7();
			System.out.println(t.reverse(1563847412));
	}
	
}
