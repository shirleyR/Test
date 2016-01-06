package com.zju;

import java.util.Scanner;

public class Main1100 {
	static int w;
	static int st[][];
	static int cnt;
	public static  void dfs(int n,int from ,int to){
		
		if(n>w)return;
		
		if(n==w){
			st[cnt][0]=from;
			st[cnt][1]=to;
			cnt++;
		}
		dfs(n+2,from<<2+3,to<<2+3);
		dfs(n+1,from<<1+1,to<<1);  ///???????
		dfs(n+1,from<<1,to<<1+1);
		
	}
	public static void main(String args[]){
		// dp[i][j]
		// 
		Scanner in =new Scanner(System.in);
		
		while(in.hasNext()){
			cnt=0;
			int h=in.nextInt();
			w=in.nextInt();
			dfs(0,0,0);
			int dp[][]=new int[h+2][3000];
			st=new int[3000][2];
			
			for(int i=1;i<=h;i++){
				for(int j=0;j<cnt;j++)
				{
					dp[i][st[j][1]]+=dp[i][st[j][0]];
				}
			}
		}
		
		
		//impdp vimas/vm@orcl directory=dir_test dumpfile=a1_2009_01.dmp dumpfile=a1_2009_02.dmp dumpfile=a1_2009_03.dmp dumpfile=a1_2009_04.dmp dumpfile=a1_2009_05.dmp dumpfile=a1_2009_06.dmp
//		String s="impdp vimas/vm@orcl directory=dir_test";
//		for(int i=1;i<10;i++){
//			s+=" dumpfile=a1_2015_0"+i+".dmp";
//		}
//		for(int i=10;i<33;i++){
//			s+=" dumpfile=a1_2015_"+i+".dmp";
//		}
//		System.out.println(s);
		
	}
	
}
