package com.zju;

import java.util.Scanner;

// 最大值最小化

//  把输入序列划分为m个连续的子序列 S(i) 均不超过x   尽量往右划分
public class Main2002 {
	static int m,k;
	static final int MAXN=505;
	static long  arr[]=new long [MAXN];
	static long sum,min,ans;
	static boolean vis[];

	static int divide(long M){
		vis=new boolean[MAXN];
		int cnt=0;
		int pos=m-1;
		while(pos>=0){
			long sum=0;
			boolean ok=true;
			while(pos>=0&&sum+arr[pos]<=M){
				ok=false;
				sum+=arr[pos];
				--pos;
			}
			if(ok) return k+1;
			if(pos>=0)vis[pos]=true;
			++cnt;
		}
		return cnt;
	}

	static long binary(){
		long left=min,right=sum,mid;
		while(left<right){
			mid=(left+right)>>1;
			if(divide(mid)<=k){
				right=mid;
			}else left=mid+1;

		}
		return right;
	}
	static void output(){
		int cnt=divide(ans);
		for(int i=0;i<m-1&&cnt<k;++i)
			if(!vis[i]){
				vis[i]=true;
				++cnt;
			}
	}
	
	public static void main(String args[]){
		int T;
		Scanner in=new Scanner(System.in);
		T=in.nextInt();
		while(T>0){
			T--;
			m=in.nextInt();
			k=in.nextInt();
			sum=0;
			min=0;
			
			for(int i=0; i<m; ++i){  
				arr[i]=in.nextInt();
	            sum += arr[i];  
	            if(arr[i]>min) min=arr[i];  
	        }  
	        ans=binary();  
	        output();
			
		}
	}
}
