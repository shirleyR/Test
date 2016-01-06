package com.test;

public class Rmq {

	static int maxsum[][]=new int[100][];
	int minsum[][]=new int [100][];
	public void RMQ(int num){
		
		for(int j=1;j<20;++j)
			for(int i=1;i<=num;i++){
				if(i+(1<<j)-1<=num){
					maxsum[i][j]=Math.max(maxsum[i][j-1],maxsum[i+(1<<(j-1))][j-1]);
					minsum[i][j]=Math.min(minsum[i][j-1],minsum[i+(1<<(j-1))][j-1]);
					
				}
			}
		
	}
	public int RMQuery(int L,int R){
		int k=0;
		while((1<<(k+1))<=R-L+1)k++;
		return Math.min(minsum[L][k],minsum[R-(1<<k)+1][k]);
	
		
	}
}
