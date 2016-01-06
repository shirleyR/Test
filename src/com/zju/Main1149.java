package com.zju;

import java.util.*;
public class Main1149 {
	// value:1-6
	// number:a[1-6]
	// 0-1 dp??
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int num[]=new int[7];
		int sum=0;
		int step=0;
		for(int i=1;i<7;i++)
		{
			num[i]=in.nextInt();
			sum+=num[i]*i;
		}
		if(sum%2!=0){
			System.out.println("No");
		}
		
		sum=sum/2;
		int dp[]=new int [sum+10];

		for(int i=1;i<7;i++){
			
			for(int j=sum;j>0;j--){
				
			}
			
		
		}

	}



}
