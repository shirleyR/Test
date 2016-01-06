package com.zju;

import java.util.*;


//Divisible
//Not divisible



public class Main2042 {
	static  int num[];
	static int flag=0;
	static int k;
	public static void statistic(int step,int t,int sum){
		if(flag==1) return;
		if(step==t){
		//	System.out.println(sum);
			if(sum%k==0){
				flag=1;
			}
			return;
		}
		int sum2= sum+num[step];
		statistic(step+1,t,sum2);
	    sum2= sum-num[step];
		statistic(step+1,t,sum2);
		
	}
	
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		while(n!=0){
			flag=0;
			n--;
			int  t;
			t=in.nextInt();
			k=in.nextInt();
			num=new int[t];
			for(int i=0;i<t;i++)
				num[i]=in.nextInt();
			
			statistic(1,t,num[0]);
			if(flag==1) System.out.println("Divisible");
			else System.out.println("Not divisible");
			
		}
				
		
	}
	
	

}
